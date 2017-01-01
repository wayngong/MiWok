package com.example.android.miwok;

/**
 * Created by gongkai on 2016/12/25.
 */

public class Word {
    // Image for miwok item
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    // English name for miwok
    private String mEnglishWord;

    // Miwok name for miwok
    private String mMiwokWord;

    // Song id
    private int mSongId = NO_SONG_PROVIDED;

    private static final int NO_SONG_PROVIDED = -1;

    public int getImageResourceId() {
        return mImageResourceID;
    }

    public String getEnglish() {
        return mEnglishWord;
    }

    public String getMiwok() {
        return mMiwokWord;
    }

    // return whether image is provided
    public boolean hasImage() {
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }

    // set Song Id
    public void setSongId(int songId) {
        mSongId = songId;
    }

    // get Song Id
    public int getSongId() {
        return mSongId;
    }

    // has Song
    public boolean hasSong(){return mSongId != NO_SONG_PROVIDED;}

    public Word(int songId, int src, String english, String miwok) {
        mSongId = songId;
        mImageResourceID = src;
        mEnglishWord = english;
        mMiwokWord = miwok;
    }

    public Word(int src, String english, String miwok) {
        mImageResourceID = src;
        mEnglishWord = english;
        mMiwokWord = miwok;
    }

    public Word(String english, String miwok) {
        mEnglishWord = english;
        mMiwokWord = miwok;
    }
}
