package com.example.schneidc.storyteller;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class CreateActivity extends ActionBarActivity {

    private Button mSubmit;
    private EditText mTitle;
    private boolean password;
    private EditText mPassword;
    private CheckBox mCheckPassword;
    private Story mStory;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        mSubmit = (Button)findViewById(R.id.submit_button);
        mTitle = (EditText)findViewById(R.id.editTitle);
        mPassword = (EditText)findViewById(R.id.editPassword);
        mCheckPassword = (CheckBox)findViewById(R.id.check_password);
        mPassword.setVisibility(View.INVISIBLE);



        mCheckPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCheckPassword.isChecked())
                {
                    mPassword.setVisibility(View.VISIBLE);
                }
                else
                {
                    mPassword.setVisibility(View.INVISIBLE);
                }
            }
        });

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStory = new Story(mTitle.getText().toString());
                Intent intent = new Intent(CreateActivity.this, WriteActivity.class);
                intent.putExtra("story", mStory);
                startActivity(intent);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create, menu);
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
