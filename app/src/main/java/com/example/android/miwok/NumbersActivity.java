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

        int srcImage = R.mipmap.ic_launcher;

        words.add(new Word(srcImage, "one","lutti"));
        words.add(new Word(srcImage, "two","otiiko"));
        words.add(new Word(srcImage, "Three","tolookosu"));
        words.add(new Word(srcImage, "Four","oyyisa"));
        words.add(new Word(srcImage, "Five","massokka"));
        words.add(new Word(srcImage, "Six","temmokka"));
        words.add(new Word(srcImage, "Seven","kenekaku"));
        words.add(new Word(srcImage, "Eight","kawinta"));
        words.add(new Word(srcImage, "Nine","wo’e"));
        words.add(new Word(srcImage, "Ten","na’aacha"));

        WordAdapter itemAdapter = new WordAdapter(this, words);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemAdapter);

//        final ListView listView = (ListView)findViewById(R.id.list);

//        for(int indexTextList=0; indexTextList<words.size(); indexTextList++){
//            TextView mTextView = new TextView(this);
//            mTextView.setText(words.get(indexTextList));
//            mTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2)); // width = match_parent, height = wrap_content
//            listView.addView(mTextView);
//        }
    }
}
