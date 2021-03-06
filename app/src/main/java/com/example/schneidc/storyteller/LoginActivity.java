package com.example.schneidc.storyteller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


public class LoginActivity extends ActionBarActivity {

    private EditText mUsernameText;
    private EditText mPasswordText;
    private Button mSubmit;
    private TextView mSignUpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsernameText = (EditText)findViewById(R.id.username);
        mPasswordText = (EditText)findViewById(R.id.password);
        mSubmit = (Button)findViewById(R.id.login_button);
        mSignUpText = (TextView)findViewById(R.id.sign_up_textview);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = mUsernameText.getText().toString();
                String password = mPasswordText.getText().toString();

                username = username.trim();
                password = password.trim();

                if (username.isEmpty() || password.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage(R.string.login_error_message);
                    builder.setTitle(R.string.error_title);
                    builder.setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else {
                    //verify user against the Parse database USER table
                    //make the progress bar visible in the action bar
                    setProgressBarIndeterminateVisibility(true);

                    //call the log in Parse method
                    MyLogInCallback callback = new MyLogInCallback();
                    ParseUser.logInInBackground(username, password, callback);
                }
            }
        });

        mSignUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

    private class MyLogInCallback implements LogInCallback {

        @Override
        public void done(ParseUser user, ParseException e) {
            setProgressBarIndeterminateVisibility(false);

            if (e == null) {
                // Success! Start the Trips activity
                Intent intent = new Intent(LoginActivity.this, OpenActivity.class);
                startActivity(intent);
            }
            else {
                // Error! display error message to user
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage(e.getMessage());
                builder.setTitle(R.string.error_title);
                builder.setPositiveButton(android.R.string.ok, null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
