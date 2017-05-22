package com.example.thedeveloper.androidactiveormappdemo.config;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by The Developer on 5/17/2017.
 */

public class Configs extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
