package com.example.android.miwok;

/**
 * Created by gongkai on 2016/12/25.
 */

public class Word {
    // Image for miwok item
    private int srcImage;

    // English name for miwok
    private String mEnglishWord;

    // Miwok name for miwok
    private String mMiwokWord;

    public int getSrcImage(){return srcImage;}

    public String getEnglish(){return mEnglishWord;}

    public String getMiwok(){return mMiwokWord;}

    public Word(int src, String english, String miwok){
        srcImage = src;
        mEnglishWord = english;
        mMiwokWord = miwok;
    }
}
