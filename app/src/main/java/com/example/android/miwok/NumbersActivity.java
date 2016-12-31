package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word(R.drawable.number_one, "one","lutti"));
        words.add(new Word(R.drawable.number_two, "two","otiiko"));
        words.add(new Word(R.drawable.number_three, "Three","tolookosu"));
        words.add(new Word(R.drawable.number_four, "Four","oyyisa"));
        words.add(new Word(R.drawable.number_five, "Five","massokka"));
        words.add(new Word(R.drawable.number_six, "Six","temmokka"));
        words.add(new Word(R.drawable.number_seven, "Seven","kenekaku"));
        words.add(new Word(R.drawable.number_eight, "Eight","kawinta"));
        words.add(new Word(R.drawable.number_nine, "Nine","wo’e"));
        words.add(new Word(R.drawable.number_ten, "Ten","na’aacha"));

        WordAdapter itemAdapter = new WordAdapter(this, words, R.color.category_numbers);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setBackgroundResource(R.color.tan_background);
        listView.setAdapter(itemAdapter);
    }
}
