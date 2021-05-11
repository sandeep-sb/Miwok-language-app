package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    //This listener gets triggered when the mediaPlayer has completed playing the audio file.
    //This is created here instead of after audio start in order to avoid repeated object creation.
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
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();

        //populating words using Word.java
        words.add(new Word("minto wuksus", "Where are you going?", R.raw.audio_phrase_where_are_you_going));
        words.add(new Word("tinnә oyaase'nә", "What is your name?", R.raw.audio_phrase_what_is_your_name));
        words.add(new Word("oyaaset...", "My name is...", R.raw.audio_phrase_my_name_is));
        words.add(new Word("michәksәs", "How are you feeling?", R.raw.audio_phrase_how_are_you_feeling));
        words.add(new Word("kuchi achit", "I'm feeling good.", R.raw.audio_phrase_im_feeling_good));
        words.add(new Word("әәnәs'aa?", "Are you coming?", R.raw.audio_phrase_are_you_coming));
        words.add(new Word("hәә’ әәnәm", "Yes, I'm coming.", R.raw.audio_phrase_yes_im_coming));
        words.add(new Word("әәnәm", "I'm coming.", R.raw.audio_phrase_im_coming));
        words.add(new Word("yoowutis", "Let's go.", R.raw.audio_phrase_lets_go));
        words.add(new Word("әnni'nem", "Come here.", R.raw.audio_phrase_come_here));

        //Custom ArrayAdapter
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((adapterView, view, position, id) -> {

            //Get the Word object at the position user clicked on
            Word selectedWord = words.get(position);

            //releasing MediaPlayer object if it currently exists before assigning it to a new audio file.
            releaseMediaPlayer();

            //Create and setup the MediaPlayer for the audio resource associated with the current word
            mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, selectedWord.getSoundResourceID());

            //Start the audio file
            mMediaPlayer.start();

            //Checking if MediaPlayer is still active by
            //performing async callbacks to mMediaPlayer.
            mMediaPlayer.setOnCompletionListener(mCompletionListener);
        });
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