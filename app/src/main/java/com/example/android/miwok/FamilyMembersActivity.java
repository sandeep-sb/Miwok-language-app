package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

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

        //ArrayList to store family member words
        ArrayList<Word> words = new ArrayList<>();

        // Word.java allows to add 2 words.
        words.add(new Word("әpә", "father", R.drawable.family_father, R.raw.audio_family_father));
        words.add(new Word("әṭa", "mother", R.drawable.family_mother, R.raw.audio_family_mother));
        words.add(new Word("angsi", "son", R.drawable.family_son, R.raw.audio_family_son));
        words.add(new Word("tune", "daughter", R.drawable.family_daughter, R.raw.audio_family_daughter));
        words.add(new Word("taachi", "older brother", R.drawable.family_older_brother, R.raw.audio_family_older_brother));
        words.add(new Word("chalitti", "younger brother", R.drawable.family_younger_brother, R.raw.audio_family_younger_brother));
        words.add(new Word("teṭe", "older sister", R.drawable.family_older_sister, R.raw.audio_family_older_sister));
        words.add(new Word("kolliti", "younger sister", R.drawable.family_younger_sister, R.raw.audio_family_younger_sister));
        words.add(new Word("ama", "grandmother", R.drawable.family_grandmother, R.raw.audio_family_grandmother));
        words.add(new Word("paapa", "grandfather", R.drawable.family_grandfather, R.raw.audio_family_grandfather));

        //Custom ArrayAdapter

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((adapterView, view, position, id) -> {

            //Get the Word object at the position user clicked on
            Word selectedWord = words.get(position);

            //releasing MediaPlayer object before assigning it to a new audio file.
            releaseMediaPlayer();

            //Create and setup the MediaPlayer for the audio resource associated with the current word
            mMediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, selectedWord.getSoundResourceID());

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