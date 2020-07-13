package com.example.khutroapp.ui.screens.activity_tabernacle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    }
}
