package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //ArraList for storing colors
        ArrayList<Word> words = new ArrayList<>();

        //Word.java file allows to store two words.
        words.add(new Word("weṭeṭṭi", "red"));
        words.add(new Word("chokokki", "red"));
        words.add(new Word("ṭakaakki", "red"));
        words.add(new Word("ṭopoppi", "red"));
        words.add(new Word("kululli", "red"));
        words.add(new Word("kelelli", "red"));
        words.add(new Word("ṭopiisә", "red"));
        words.add(new Word("chiwiiṭә", "red"));

        //Custom ArrayAdapter
        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}