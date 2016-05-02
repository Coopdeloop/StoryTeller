package com.example.schneidc.storyteller;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;

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

    public ParseObject toParseObject(){
        ParseObject obj = new ParseObject("Entry");
        obj.put("creator", mCreator);
        obj.put("Content", mContents);
        obj.put("position", mId);
        return obj;
    }
}
