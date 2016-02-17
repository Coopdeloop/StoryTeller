package com.example.schneidc.storyteller;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SignUpActivity extends ActionBarActivity {
    private EditText mUsername;
    private EditText mPassword;
    private EditText mConfirmPass;
    private Button mSubmit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mUsername = (EditText)findViewById(R.id.sign_up_user);
        mPassword = (EditText)findViewById(R.id.sign_up_pass);
        mConfirmPass = (EditText)findViewById(R.id.sign_up_confirm);

        mSubmit = (Button)findViewById(R.id.sign_up_button);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();
                String conPass = mConfirmPass.getText().toString();

                password = password.trim();
                conPass = conPass.trim();
                username = username.trim();

                if(username.isEmpty() || password.isEmpty() || conPass.isEmpty())
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                    builder.setMessage(R.string.empty_error_message);
                    builder.setTitle(R.string.error_title);
                    builder.setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else
                {
                    if(password.length() < 6)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                        builder.setMessage(R.string.password_length_message);
                        builder.setTitle(R.string.error_title);
                        builder.setPositiveButton(android.R.string.ok, null);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }


                    else if (password.equals(username))
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                        builder.setMessage(R.string.password_username_message);
                        builder.setTitle(R.string.error_title);
                        builder.setPositiveButton(android.R.string.ok, null);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }

                    else if(!password.equals(conPass))
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                        builder.setMessage(R.string.password_confirmation_message);
                        builder.setTitle(R.string.error_title);
                        builder.setPositiveButton(android.R.string.ok, null);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }


                }




                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
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
