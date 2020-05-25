package com.prod.nucleohealth.application;

import android.app.Application;

public class AppController extends Application {
    private static final String TAG = "AppController";
    private static AppController mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    public static synchronized AppController getInstance() {
        return mInstance;
    }
}
