package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<>();

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

        words.add(new Word("lutti", "one", R.drawable.number_one, R.raw.audio_number_one));
        words.add(new Word("otiiko", "two", R.drawable.number_two, R.raw.audio_number_two));
        words.add(new Word("tolokoosu", "three", R.drawable.number_three, R.raw.audio_number_three));
        words.add(new Word("oyyisa", "four", R.drawable.number_four, R.raw.audio_number_four));
        words.add(new Word("massokka", "five", R.drawable.number_five, R.raw.audio_number_five));
        words.add(new Word("temmokka", "six", R.drawable.number_six, R.raw.audio_number_six));
        words.add(new Word("kenekaku", "seven", R.drawable.number_seven, R.raw.audio_number_seven));
        words.add(new Word("kawinta", "eight", R.drawable.number_eight, R.raw.audio_number_eight));
        words.add(new Word("wo'e", "nine", R.drawable.number_nine, R.raw.audio_number_nine));
        words.add(new Word("na'aacha", "ten", R.drawable.number_ten, R.raw.audio_number_ten));


//        //Find the root view of the whole layout.
//        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        //Adding the setOnClickItemListener for audio file
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                //Get the Word object at the position user clicked on
                Word selectedWord = words.get(position);

                //Create and setup the MediaPlayer for the audio resource associated with the current word
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, selectedWord.getSoundResourceID());

                //Start the audio file
                mMediaPlayer.start();
            }
        });


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