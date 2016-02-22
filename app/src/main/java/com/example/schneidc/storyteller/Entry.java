package com.example.schneidc.storyteller;

/**
 * Created by wysockij00 on 2/22/16.
 */
public class Entry {
    private int mId;
    private String mCreator;
    private String mContents;

    public Entry(String creator, String contents, int id) {

        mId = id;
        mCreator = creator;
        mContents = contents;
    }

    public String getCreator() {
        return mCreator;
    }

    public int getId() {
        return mId;
    }

    public String getContents() {
        return mContents;
    }
}
