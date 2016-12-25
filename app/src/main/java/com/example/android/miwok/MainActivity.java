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

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Get Numbers TextView
        TextView numbers = (TextView) findViewById(R.id.numbers);

        // Set OnClickListener to Numbers
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Go to Numbers", Toast.LENGTH_SHORT).show();
                /*
                * Create Intent for Numbers
                * */
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });

        // Get Family Members TextView
        TextView family_mumbers = (TextView) findViewById(R.id.family);

        // Set OnClickListener to Family Members
        family_mumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Go to Family Members", Toast.LENGTH_SHORT).show();
                 /*
                * Create Intent for Family Members
                * */
                Intent familyMembersIntent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(familyMembersIntent);
            }
        });

        // Get Colors TextView
        TextView colors = (TextView) findViewById(R.id.colors);

        // Set OnClickListener to Colors
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Go to Colors", Toast.LENGTH_SHORT).show();
                 /*
                * Create Intent for Colors
                * */
                Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(colorsIntent);
            }
        });

        // Get Phrases TextView
        TextView phrases = (TextView) findViewById(R.id.phrases);

        // Set OnClickListener to Phrases
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Go to Phrases", Toast.LENGTH_SHORT).show();
                 /*
                * Create Intent for Phrases
                * */
                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(phrasesIntent);
            }
        });
    }
}
