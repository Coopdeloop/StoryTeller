package com.example.schneidc.storyteller;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.io.Writer;
import java.util.ArrayList;


public class WriteActivity extends ActionBarActivity {


    private static final String TAG = WriteActivity.class.getName();
    private TextView mTitleView;
    private TextView mStoryView;
    private EditText mInputText;
    private Button mSubmitButton;
    private Story mStory;
    private String mTitle;
    private ParseObject fullStory;
    private String mText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        mTitle = getIntent().getStringExtra("title");
        mText = getIntent().getStringExtra("text");
        mStory = new Story(mTitle);
        if(mTitle.isEmpty() && mText.isEmpty()){
            fullStory = new ParseObject("Story");
            fullStory.put("Title", mTitle);
            fullStory.saveInBackground();
        }

        mTitleView = (TextView)findViewById(R.id.titleView);
        mTitleView.setText(mTitle);
        mStoryView = (TextView)findViewById(R.id.storyText);
        mStoryView.setText(mText);
        mInputText = (EditText)findViewById(R.id.inputText);
        mSubmitButton = (Button)findViewById(R.id.submitButton);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Entry entry = new Entry(ParseUser.getCurrentUser().getString("username"), mInputText.getText().toString(), mStory.getEntryNumber());
                Log.i(TAG, "In activity,the entry is: " + entry.toString());
                mStory.addEntry(entry);


                fullStory.put("FullStory", mStory.getEntries());
                fullStory.saveInBackground();
                mStoryView.setText(mStory.getStory());

                mInputText.setText("");
            }
        });

        mStoryView.setMovementMethod(new ScrollingMovementMethod());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_write, menu);
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
