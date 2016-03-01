package com.example.schneidc.storyteller;

import java.util.ArrayList;

/**
 * Created by wysockij00 on 2/22/16.
 */
public class Story {
    private ArrayList<Entry> mEntries;
    private String mTitle;

    public Story(String title) {
        mTitle = title;
        mEntries = new ArrayList<>();
    }

    public void addEntry(Entry e){
        mEntries.add(e);
    }

    public void deleteEntry(Entry e){
        mEntries.remove(e);
    }

    public int getEntryNumber(){
        return mEntries.size();
    }

    public String getStory(){
        StringBuilder builder = new StringBuilder();
        for (Entry entry : mEntries){
            builder.append(entry.getContents() + " ");

        }
        return builder.toString();
    }
}
