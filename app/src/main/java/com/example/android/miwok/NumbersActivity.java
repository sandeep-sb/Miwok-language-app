package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Word> words = new ArrayList<Word>();

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

        words.add(new Word("lutti", "one"));
        words.add(new Word("otiiko", "two"));
        words.add(new Word("tolokoosu", "three"));
        words.add(new Word("oyyisa", "four"));
        words.add(new Word("massokka", "five"));
        words.add(new Word("temmokka", "six"));
        words.add(new Word("kenekaku", "seven"));
        words.add(new Word("kawinta", "eight"));
        words.add(new Word("wo'e", "nine"));
        words.add(new Word("na'aacha", "ten"));


//        //Find the root view of the whole layout.
//        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);


        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);


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
}