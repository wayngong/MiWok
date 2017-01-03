package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;


public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer = null;

    private AudioManager mAudioManager = null;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

//        getActionBar().setDisplayHomeAsUpEnabled(true);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word(R.raw.test, R.drawable.number_one, "one", "lutti"));
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
                Log.i("ItemClick", "Play Media");
                releaseMediaPlayer();
                Word word = words.get(position);
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // get Audio Focus Now
//            mAudioManager.registerMediaButtonEventReceiver(RemoteControlReceiver);

                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getSongId());

                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                } else {
                    // get Audio Focus Failed
                }

            }
        });

        AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
                new AudioManager.OnAudioFocusChangeListener() {
                    @Override
                    public void onAudioFocusChange(int focusChange) {
                        if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                            Log.i("AudioFocusChange", "GAIN");
                            if (mMediaPlayer != null) {
                                mMediaPlayer.start();
                            }
                        } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                            Log.i("AudioFocusChange", "LOSS");
                            if (mMediaPlayer != null) {
                                mMediaPlayer.stop();
                                releaseMediaPlayer();
                            }
                        } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                                focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                            Log.i("AudioFocusChange", "LOSS TRANSIENT");
                            if (mMediaPlayer != null) {
                                mMediaPlayer.pause();
                                mMediaPlayer.seekTo(0);
                            }
                        }
                    }
                };


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
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
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
