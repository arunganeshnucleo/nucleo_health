package com.prod.nucleohealth.view.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.prod.nucleohealth.R;

public class SignupActivity extends AppCompatActivity {


    private static int SPLASH_TIME_OUT = 3000;
    String deviceToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
}
