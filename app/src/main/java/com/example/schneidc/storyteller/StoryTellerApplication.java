package com.example.schneidc.storyteller;

import android.app.Application;

import com.parse.Parse;


/**
 * Created by schneidc on 2/17/16.
 */
public class StoryTellerApplication extends Application {

        private final String APPLICATION_ID = "qZBWVnF35HMwOC91XQK6HfmAjFpwMeDizMT1foue";
        private final String CLIENT_KEY = "AhoQNM63mHda2CISUeISShk1DQRtLpMDab5fe8vU";

        @Override
        public void onCreate() {
            super.onCreate();
            Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);
        }

    }

