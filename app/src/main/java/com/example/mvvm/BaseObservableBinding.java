package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BaseObservableBinding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_observable_binding);
    }
}