package com.example.khutroapp.ui.screens.activity_infringe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.khutroapp.R;

public class ActivityInfringe extends AppCompatActivity {
    String users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infringe);
        Intent intent = getIntent();
        users = intent.getStringExtra("Username");
    }
}
