package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

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

            //Create and setup the MediaPlayer for the audio resource associated with the current word
            mMediaPlayer = MediaPlayer.create(ColorsActivity.this, selectedWord.getSoundResourceID());

            //Start the audio file
            mMediaPlayer.start();
        });
    }
}