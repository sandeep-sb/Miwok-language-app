package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

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

        //ArraList for storing colors
        ArrayList<Word> words = new ArrayList<>();

        //Word.java file allows to store two words.
        words.add(new Word("weṭeṭṭi", "red", R.drawable.color_red, R.raw.audio_color_red));
        words.add(new Word("chokokki", "green", R.drawable.color_green, R.raw.audio_color_green));
        words.add(new Word("ṭakaakki", "brown", R.drawable.color_brown, R.raw.audio_color_brown));
        words.add(new Word("ṭopoppi", "gray", R.drawable.color_gray, R.raw.audio_color_gray));
        words.add(new Word("kululli", "black", R.drawable.color_black, R.raw.audio_color_black));
        words.add(new Word("kelelli", "white", R.drawable.color_white, R.raw.audio_color_white));
        words.add(new Word("ṭopiisә", "dusty yellow", R.drawable.color_dusty_yellow, R.raw.audio_color_dusty_yellow));
        words.add(new Word("chiwiiṭә", "mustard yellow", R.drawable.color_mustard_yellow, R.raw.audio_color_mustard_yellow));

        //Custom ArrayAdapter
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((adapterView, view, position, id) -> {

            //Get the Word object at the position user clicked on
            Word selectedWord = words.get(position);

            //releasing MediaPlayer object before assigning it to a new audio file.
            releaseMediaPlayer();

            //Create and setup the MediaPlayer for the audio resource associated with the current word
            mMediaPlayer = MediaPlayer.create(ColorsActivity.this, selectedWord.getSoundResourceID());

            //Start the audio file
            mMediaPlayer.start();

            //Checking if MediaPlayer is still active by
            //performing async callbacks to mMediaPlayer.
            mMediaPlayer.setOnCompletionListener(mCompletionListener);
        });
    }
}