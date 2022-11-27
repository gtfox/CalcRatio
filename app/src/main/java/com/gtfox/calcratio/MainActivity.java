package com.gtfox.calcratio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_YES);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}