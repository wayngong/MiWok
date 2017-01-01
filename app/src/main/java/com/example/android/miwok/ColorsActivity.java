package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.miwok.R.id.miwok_text_view;
import static com.example.android.miwok.R.id.miwok_text_view_list;
import static com.example.android.miwok.R.layout.word_list;

public class ColorsActivity extends AppCompatActivity {
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
        setContentView(word_list);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word(R.drawable.color_red, "red","weṭeṭṭi"));
        words.add(new Word(R.drawable.color_green, "green","chokokki"));
        words.add(new Word(R.drawable.color_brown, "brown","ṭakaakki"));
        words.add(new Word(R.drawable.color_gray, "gray","ṭopoppi"));
        words.add(new Word(R.drawable.color_black, "black","kululli"));
        words.add(new Word(R.drawable.color_white, "white","kelelli"));
        words.add(new Word(R.drawable.color_dusty_yellow, "dusty yellow","ṭopiisə"));
        words.add(new Word(R.drawable.color_mustard_yellow, "mustard yellow","chiwiiṭə"));

//        LinearLayout linearLayoutList = (LinearLayout) findViewById(R.id.miwok_text_view_list);
//        linearLayoutList.setBackgroundResource(R.color.category_colors);

//        ImageView imageView = (ImageView) findViewById(R.id.miwok_image_view);
//        imageView.setBackgroundResource(R.color.tan_background);

        WordAdapter itemAdapter = new WordAdapter(this, words, R.color.category_colors);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setBackgroundResource(R.color.tan_background);
        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getImageResourceId());
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
