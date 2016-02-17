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


public class WriteActivity extends ActionBarActivity {


    private TextView mTitleView;
    private TextView mStoryView;
    private EditText mInputText;
    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        mTitleView = (TextView)findViewById(R.id.titleView);
        mStoryView = (TextView)findViewById(R.id.storyText);
        mInputText = (EditText)findViewById(R.id.inputText);
        mSubmitButton = (Button)findViewById(R.id.submitButton);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newSentence = mInputText.getText().toString().trim();
                mStoryView.append(" " + newSentence);
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
