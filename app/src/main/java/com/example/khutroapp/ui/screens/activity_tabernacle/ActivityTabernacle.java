package com.example.khutroapp.ui.screens.activity_tabernacle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_tabernacle.adapter.TabernacleAdapter;
import com.example.khutroapp.ui.screens.activity_tabernacle.connect.TabernacleConnect;
import com.example.khutroapp.ui.screens.activity_tabernacle.model.TabernacleModel;

import java.sql.SQLException;
import java.util.List;

public class ActivityTabernacle extends AppCompatActivity {
    String users;
    TabernacleConnect tabernacleConnect=new TabernacleConnect();
    TabernacleAdapter adapter;
    ImageView img_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabernacle);

        Intent intent = getIntent();
        users = intent.getStringExtra("Username");

        List<TabernacleModel> tabernacleModels= null;
        try {
            tabernacleModels = tabernacleConnect.loadTabernacle(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final ListView listView = findViewById(R.id.listviewTabernacle);
        adapter= new TabernacleAdapter(this,tabernacleModels);
        listView.setAdapter(adapter);
        img_back=findViewById(R.id.img_backTabernacle);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
