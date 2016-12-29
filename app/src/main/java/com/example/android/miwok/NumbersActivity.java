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

        words.add(new Word("one","lutti"));
        words.add(new Word("two","otiiko"));
        words.add(new Word("Three","tolookosu"));
        words.add(new Word("Four","oyyisa"));
        words.add(new Word("Five","massokka"));
        words.add(new Word("Six","temmokka"));
        words.add(new Word("Seven","kenekaku"));
        words.add(new Word("Eight","kawinta"));
        words.add(new Word("Nine","wo’e"));
        words.add(new Word("Ten","na’aacha"));

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
