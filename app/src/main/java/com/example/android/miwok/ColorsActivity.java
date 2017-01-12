package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ColorsFragment())
                .commit();
    }
}
//words.add(new Word(R.drawable.color_red, "red","weṭeṭṭi"));
//        words.add(new Word(R.drawable.color_green, "green","chokokki"));
//        words.add(new Word(R.drawable.color_brown, "brown","ṭakaakki"));
//        words.add(new Word(R.drawable.color_gray, "gray","ṭopoppi"));
//        words.add(new Word(R.drawable.color_black, "black","kululli"));
//        words.add(new Word(R.drawable.color_white, "white","kelelli"));
//        words.add(new Word(R.drawable.color_dusty_yellow, "dusty yellow","ṭopiisə"));
//        words.add(new Word(R.drawable.color_mustard_yellow, "mustard yellow","chiwiiṭə"));