package com.example.schneidc.storyteller;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by wysockij00 on 2/22/16.
 */
public class Story implements Serializable{
    private ArrayList<Entry> mEntries;
    private String mTitle;
    private String mPassword;

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

    public String getTitle() {
        return mTitle;
    }
}
