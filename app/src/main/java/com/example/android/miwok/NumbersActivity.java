package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();

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

        words.add(new Word("lutti", "one", R.drawable.number_one));
        words.add(new Word("otiiko", "two", R.drawable.number_two));
        words.add(new Word("tolokoosu", "three", R.drawable.number_three));
        words.add(new Word("oyyisa", "four", R.drawable.number_four));
        words.add(new Word("massokka", "five", R.drawable.number_five));
        words.add(new Word("temmokka", "six", R.drawable.number_six));
        words.add(new Word("kenekaku", "seven", R.drawable.number_seven));
        words.add(new Word("kawinta", "eight", R.drawable.number_eight));
        words.add(new Word("wo'e", "nine", R.drawable.number_nine));
        words.add(new Word("na'aacha", "ten", R.drawable.number_ten));


//        //Find the root view of the whole layout.
//        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

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