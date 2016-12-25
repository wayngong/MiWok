package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
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


        ArrayList<String> words = new ArrayList<String>();

        for (int i=0;i<100;i++){
            words.add(""+i);
        }

        ArrayAdapter itemAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, words);
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
