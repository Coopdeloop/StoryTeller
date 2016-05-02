package com.example.schneidc.storyteller;

import com.parse.ParseObject;

import java.util.ArrayList;

/**
 * Created by wysockij00 on 2/22/16.
 */
public class Story {
    private ArrayList<ParseObject> mEntries;
    private String mTitle;

    public Story(String title) {
        mTitle = title;
        mEntries = new ArrayList<>();
    }

    public void addEntry(Entry e){
        mEntries.add(e.toParseObject());
    }

    public void deleteEntry(Entry e){
        mEntries.remove(e);
    }

    public int getEntryNumber(){
        return mEntries.size();
    }

    public ArrayList<ParseObject> getEntries(){
        return mEntries;
    }

    public String getStory(){
        StringBuilder builder = new StringBuilder();
        for (ParseObject entry : mEntries){
            builder.append(entry.getString("Content") + " ");

        }
        return builder.toString();
    }
}
