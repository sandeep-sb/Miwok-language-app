package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

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
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((adapterView, view, position, id) -> {

            //Get the Word object at the position user clicked on
            Word selectedWord = words.get(position);

            //Create and setup the MediaPlayer for the audio resource associated with the current word
            mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, selectedWord.getSoundResourceID());

            //Start the audio file
            mMediaPlayer.start();
        });
    }
}