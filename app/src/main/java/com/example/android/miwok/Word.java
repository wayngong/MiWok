package com.example.android.miwok;

/**
 * Created by gongkai on 2016/12/25.
 */

public class Word {
    // English name for miwok
    private String mEnglishWord;

    // Miwok name for miwok
    private String mMiwokWord;

    public String getEnglish(){return mEnglishWord;}

    public String getMiwok(){return mMiwokWord;}

    public Word( String english, String miwok){
        mEnglishWord = english;
        mMiwokWord = miwok;
    }
}
