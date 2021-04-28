package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //ArrayList to store family member words
        ArrayList<Word> words = new ArrayList<>();

        // Word.java allows to add 2 words.
        words.add(new Word("әpә", "father"));
        words.add(new Word("әṭa", "wife"));
        words.add(new Word("angsi", "son"));
        words.add(new Word("tune", "dadugter"));
        words.add(new Word("taachi", "older brother"));
        words.add(new Word("chalitti", "younger brother"));
        words.add(new Word("teṭe", "older sister"));
        words.add(new Word("kolliti", "younger sister"));
        words.add(new Word("ama", "grandmother"));
        words.add(new Word("paapa", "grandfather"));

        //Custom ArrayAdapter

        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}