package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.miwok.R.id.miwok_text_view;
import static com.example.android.miwok.R.id.miwok_text_view_list;
import static com.example.android.miwok.R.layout.word_list;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(word_list);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word(R.drawable.color_red, "red","weṭeṭṭi"));
        words.add(new Word(R.drawable.color_green, "green","chokokki"));
        words.add(new Word(R.drawable.color_brown, "brown","ṭakaakki"));
        words.add(new Word(R.drawable.color_gray, "gray","ṭopoppi"));
        words.add(new Word(R.drawable.color_black, "black","kululli"));
        words.add(new Word(R.drawable.color_white, "white","kelelli"));
        words.add(new Word(R.drawable.color_dusty_yellow, "dusty yellow","ṭopiisə"));
        words.add(new Word(R.drawable.color_mustard_yellow, "mustard yellow","chiwiiṭə"));

//        LinearLayout linearLayoutList = (LinearLayout) findViewById(R.id.miwok_text_view_list);
//        linearLayoutList.setBackgroundResource(R.color.category_colors);

//        ImageView imageView = (ImageView) findViewById(R.id.miwok_image_view);
//        imageView.setBackgroundResource(R.color.tan_background);

        WordAdapter itemAdapter = new WordAdapter(this, words, R.color.category_colors);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setBackgroundResource(R.color.tan_background);
        listView.setAdapter(itemAdapter);


    }
}
