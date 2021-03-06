package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;

    /** Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    AudioManager.OnAudioFocusChangeListener mAudioFocusChange = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_GAIN_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK){
                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                mMediaPlayer.stop();
                releaseMediaPlayer();
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_GAIN){
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            }
        }
    };

    /**This listener gets triggered when the mediaPlayer has completed playing the audio file.
    *This is created here instead of after audio start in order to avoid repeated object creation.*/
    private final MediaPlayer.OnCompletionListener mCompletionListener = mediaPlayer -> releaseMediaPlayer();

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
            mAudioManager.abandonAudioFocus(mAudioFocusChange);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Requesting audioFocus just before playing audio file
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<>();

//        words.add("one");
//        words.add("two");
//        words.add("three");
//        words.add("four");
//        words.add("five");
//        words.add("six");
//        words.add("seven");
//        words.add("eight");
//        words.add("nine");
//        words.add("ten");

        words.add(new Word("lutti", "one", R.drawable.number_one, R.raw.audio_number_one));
        words.add(new Word("otiiko", "two", R.drawable.number_two, R.raw.audio_number_two));
        words.add(new Word("tolokoosu", "three", R.drawable.number_three, R.raw.audio_number_three));
        words.add(new Word("oyyisa", "four", R.drawable.number_four, R.raw.audio_number_four));
        words.add(new Word("massokka", "five", R.drawable.number_five, R.raw.audio_number_five));
        words.add(new Word("temmokka", "six", R.drawable.number_six, R.raw.audio_number_six));
        words.add(new Word("kenekaku", "seven", R.drawable.number_seven, R.raw.audio_number_seven));
        words.add(new Word("kawinta", "eight", R.drawable.number_eight, R.raw.audio_number_eight));
        words.add(new Word("wo'e", "nine", R.drawable.number_nine, R.raw.audio_number_nine));
        words.add(new Word("na'aacha", "ten", R.drawable.number_ten, R.raw.audio_number_ten));


        int result = mAudioManager.requestAudioFocus(mAudioFocusChange, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);




//        //Find the root view of the whole layout.
//        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        //Adding the setOnClickItemListener for audio file
        listView.setOnItemClickListener((adapterView, view, position, id) -> {

            //Get the Word object at the position user clicked on
            Word selectedWord = words.get(position);

            //releasing MediaPlayer object before assigning it to a new audio file.
            releaseMediaPlayer();

            //Create and setup the MediaPlayer for the audio resource associated with the current word
            mMediaPlayer = MediaPlayer.create(NumbersActivity.this, selectedWord.getSoundResourceID());


            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                //Start the audio file
                mMediaPlayer.start();

                //Checking if MediaPlayer is still active by
                //performing async callbacks to mMediaPlayer.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });



//        //Setup counter variable to keep track of index position.
//        for(int index = 0; index < words.size(); index ++) {
//
//            //Create a new {@link TextView} that display the word on the screen
//            //and add child View to the parent View
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(index));
//            rootView.addView(wordView);
//
//        }
    }


    /** onStop function of Activity lifecycle is called in order to release resources
     *  after the user has exited the application
     */
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}