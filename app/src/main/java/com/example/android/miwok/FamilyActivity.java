package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();

        int srcImage = R.mipmap.ic_launcher;

        words.add(new Word(srcImage, "father","əpə"));
        words.add(new Word(srcImage, "mother","əṭa"));
        words.add(new Word(srcImage, "son","angsi"));
        words.add(new Word(srcImage, "daughter","tune"));
        words.add(new Word(srcImage, "older brother","taachi"));
        words.add(new Word(srcImage, "younger brother","chalitti"));
        words.add(new Word(srcImage, "older sister","teṭe"));
        words.add(new Word(srcImage, "younger sister","kolliti"));
        words.add(new Word(srcImage, "grandmother","ama"));
        words.add(new Word(srcImage, "grandfather","paapa"));

        WordAdapter itemadapter = new WordAdapter(this, words);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemadapter);


    }
}
