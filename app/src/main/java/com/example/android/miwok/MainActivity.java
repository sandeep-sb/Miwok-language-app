/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //Find a view that shows the numbers category
        TextView numbers = (TextView) findViewById(R.id.numbers);
        //Set the Click Listeners on that view
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });

        //Find the view that shows the Family Members activity
        TextView familyMembers = (TextView) findViewById(R.id.family);
        //Set the Click Listeners on that view
        familyMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, FamilyMembersActivity.class);
                startActivity(numbersIntent);
            }
        });

        //Find the view that shows the colors activity
        TextView colors = (TextView) findViewById(R.id.colors);
        //Set the Click Listener on that View
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(numbersIntent);
            }
        });

        //Find the view that shows the phrases activity
        TextView phrases = (TextView) findViewById(R.id.phrases);
        //Set the Click Listener on that View
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(numbersIntent);
            }
        });

    }


}
