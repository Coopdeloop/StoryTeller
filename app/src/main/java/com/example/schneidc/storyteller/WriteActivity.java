package com.example.schneidc.storyteller;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
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


    private TextView mTitleView;
    private TextView mStoryView;
    private EditText mInputText;
    private Button mSubmitButton;
    private Story mStory;
    private String mTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        mTitle = getIntent().getStringExtra("title");
        ParseProxyObject ppo = (ParseProxyObject) getIntent().getSerializableExtra("parseObject");
        mStory = new Story(mTitle);
        mTitleView = (TextView)findViewById(R.id.titleView);
        mStoryView = (TextView)findViewById(R.id.storyText);
        mInputText = (EditText)findViewById(R.id.inputText);
        mSubmitButton = (Button)findViewById(R.id.submitButton);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Entry entry = new Entry(ParseUser.getCurrentUser().getString("username"), mInputText.getText().toString(), mStory.getEntryNumber());
                mStory.addEntry(entry);
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
