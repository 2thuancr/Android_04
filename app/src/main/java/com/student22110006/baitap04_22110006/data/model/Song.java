package com.student22110006.baitap04_22110006.data.model;

import java.io.Serializable;

public class Song implements Serializable {
    private String mCode;
    private String mTitle;
    private String mLyric;
    private String mArtist;

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmLyric() {
        return mLyric;
    }

    public void setmLyric(String mLyric) {
        this.mLyric = mLyric;
    }

    public String getmArtist() {
        return mArtist;
    }

    public void setmArtist(String mArtist) {
        this.mArtist = mArtist;
    }

    public Song(String mCode, String mTitle, String mLyric, String mArtist) {
        this.mCode = mCode;
        this.mTitle = mTitle;
        this.mLyric = mLyric;
        this.mArtist = mArtist;
    }
}
