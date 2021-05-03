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
        words.add(new Word("weṭeṭṭi", "red", R.drawable.color_red));
        words.add(new Word("chokokki", "green", R.drawable.color_green));
        words.add(new Word("ṭakaakki", "brown", R.drawable.color_brown));
        words.add(new Word("ṭopoppi", "gray", R.drawable.color_gray));
        words.add(new Word("kululli", "black", R.drawable.color_black));
        words.add(new Word("kelelli", "white", R.drawable.color_white));
        words.add(new Word("ṭopiisә", "dusty yellow", R.drawable.color_dusty_yellow));
        words.add(new Word("chiwiiṭә", "mustard yellow", R.drawable.color_mustard_yellow));

        //Custom ArrayAdapter
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}