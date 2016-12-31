package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();

        int srcImage = R.mipmap.ic_launcher;

        words.add(new Word(srcImage, "red","weṭeṭṭi"));
        words.add(new Word(srcImage, "green","chokokki"));
        words.add(new Word(srcImage, "brown","ṭakaakki"));
        words.add(new Word(srcImage, "gray","ṭopoppi"));
        words.add(new Word(srcImage, "black","kululli"));
        words.add(new Word(srcImage, "white","kelelli"));
        words.add(new Word(srcImage, "dusty yellow","ṭopiisə"));
        words.add(new Word(srcImage, "mustard yellow","chiwiiṭə"));

        WordAdapter itemAdapter = new WordAdapter(this, words);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemAdapter);

    }
}
