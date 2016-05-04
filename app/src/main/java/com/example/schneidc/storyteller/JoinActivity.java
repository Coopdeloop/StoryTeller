package com.example.schneidc.storyteller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.util.ArrayList;


public class JoinActivity extends ActionBarActivity {

    private static final String TAG = JoinActivity.class.getName();
    private ArrayList<String> mStories;
    private ListView mStoryList;
    private TextView mPageTitle;
    private ArrayList<String> fullStory = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        mPageTitle = (TextView) findViewById(R.id.pageTitle);
        mPageTitle.setText("Join a Story");
        mStoryList = (ListView) findViewById(R.id.storyList);

        final ParseQueryAdapter<ParseObject> adapter = new ParseQueryAdapter<>(this, "Story");
        adapter.setTextKey("Title");
        mStoryList.setAdapter(adapter);

        mStoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = adapter.getItem(mStoryList.getPositionForView(view)).getString("Title");
                @SuppressWarnings("unchecked") ArrayList<ParseObject> storyPointers = (ArrayList<ParseObject>) adapter.getItem(mStoryList.getPositionForView(view)).get("FullStory");

                final StringBuilder story = new StringBuilder();
                final ArrayList<String> storyStrings = new ArrayList<>(storyPointers.size());

                for (int i = 0; i < storyPointers.size(); i++) {

                    try {
                        ParseQuery.getQuery("Entry").get(storyPointers.get(i).getObjectId()).fetchInBackground(new GetCallback<ParseObject>() {
                            @Override
                            public void done(ParseObject parseObject, ParseException e) {
                                Log.i(TAG, "Content is: " + parseObject.get("Content"));
                                story.append(parseObject.getString("Content"));
                                Log.i(TAG, storyStrings.toString());
                                storyStrings.set(parseObject.getInt("Position"),parseObject.getString("Content"));
                            }
                        });
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                Intent intent = new Intent(getBaseContext(), WriteActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("text", fullStory);
                //startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_join, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
