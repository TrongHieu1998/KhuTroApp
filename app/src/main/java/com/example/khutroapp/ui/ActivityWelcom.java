package com.example.khutroapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screenchutro.activity_login_ct.ActivityLoginCT;
import com.example.khutroapp.ui.screens.activity_login.ActivityLogin;

public class ActivityWelcom extends AppCompatActivity {
    Button btn_chutro,btn_khachthue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        btn_chutro=findViewById(R.id.btn_loginChuTro);
        btn_chutro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ActivityWelcom.this, ActivityLoginCT.class);
                startActivity(intent);
            }
        });
        btn_khachthue=findViewById(R.id.btn_loginKhachthue);
        btn_khachthue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ActivityWelcom.this, ActivityLogin.class);
                startActivity(intent);
            }
        });
    }
}