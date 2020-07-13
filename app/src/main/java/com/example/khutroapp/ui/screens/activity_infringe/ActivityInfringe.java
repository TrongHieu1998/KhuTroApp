package com.example.khutroapp.ui.screens.activity_infringe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_infringe.adapter.InfringeAdapter;
import com.example.khutroapp.ui.screens.activity_infringe.connect.InfringeConnect;
import com.example.khutroapp.ui.screens.activity_infringe.model.InfringeModel;
import com.example.khutroapp.ui.screens.activity_roommate.adapter.RoommateAdapter;
import com.example.khutroapp.ui.screens.activity_roommate.model.RoommateModel;

import java.sql.SQLException;
import java.util.List;

public class ActivityInfringe extends AppCompatActivity {
    InfringeConnect infringeConnect= new InfringeConnect();
    InfringeAdapter adapter;
    String users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infringe);

        Intent intent = getIntent();
        users = intent.getStringExtra("Username");

        List<InfringeModel> infringeModels= null;
        try {
            infringeModels = infringeConnect.loadInfringe(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final ListView listView = findViewById(R.id.listviewInfringe);
        adapter= new InfringeAdapter(this,infringeModels);
        listView.setAdapter(adapter);
    }
}
