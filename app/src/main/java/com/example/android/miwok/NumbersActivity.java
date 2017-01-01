package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word(R.raw.number_one, R.drawable.number_one, "one", "lutti"));
        words.add(new Word(R.raw.number_two, R.drawable.number_two, "two", "otiiko"));
        words.add(new Word(R.raw.number_three, R.drawable.number_three, "Three", "tolookosu"));
        words.add(new Word(R.raw.number_four, R.drawable.number_four, "Four", "oyyisa"));
        words.add(new Word(R.raw.number_five, R.drawable.number_five, "Five", "massokka"));
        words.add(new Word(R.raw.number_six, R.drawable.number_six, "Six", "temmokka"));
        words.add(new Word(R.raw.number_seven, R.drawable.number_seven, "Seven", "kenekaku"));
        words.add(new Word(R.raw.number_eight, R.drawable.number_eight, "Eight", "kawinta"));
        words.add(new Word(R.raw.number_nine, R.drawable.number_nine, "Nine", "wo’e"));
        words.add(new Word(R.raw.number_ten, R.drawable.number_ten, "Ten", "na’aacha"));

        WordAdapter itemAdapter = new WordAdapter(this, words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setBackgroundResource(R.color.tan_background);
        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getImageResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
//            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
