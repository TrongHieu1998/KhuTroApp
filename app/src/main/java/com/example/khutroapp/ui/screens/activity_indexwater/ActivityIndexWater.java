package com.example.khutroapp.ui.screens.activity_indexwater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_indexwater.adapter.IndexWaterAdapter;
import com.example.khutroapp.ui.screens.activity_indexwater.connect.IndexWaterConnect;
import com.example.khutroapp.ui.screens.activity_indexwater.model.IndexWaterModel;

import java.sql.SQLException;
import java.util.List;

public class ActivityIndexWater extends AppCompatActivity {
    String users;
    IndexWaterConnect indexWaterConnect= new IndexWaterConnect();
    IndexWaterAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_water);

        Intent intent = getIntent();
        users = intent.getStringExtra("Username");

        List<IndexWaterModel> indexWaterModels= null;
        try {
            indexWaterModels = indexWaterConnect.loadIndexWater(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final ListView listView = findViewById(R.id.listviewIndexWater);
        adapter= new IndexWaterAdapter(this,indexWaterModels);
        listView.setAdapter(adapter);
    }
}
