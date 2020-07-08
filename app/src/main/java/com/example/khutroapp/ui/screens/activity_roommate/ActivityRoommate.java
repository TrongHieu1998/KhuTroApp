package com.example.khutroapp.ui.screens.activity_roommate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_contract.adapter.ContractAdapter;
import com.example.khutroapp.ui.screens.activity_roommate.adapter.RoommateAdapter;
import com.example.khutroapp.ui.screens.activity_roommate.connect.RoommateConnect;
import com.example.khutroapp.ui.screens.activity_roommate.model.RoommateModel;

import java.sql.SQLException;
import java.util.List;

public class ActivityRoommate extends AppCompatActivity {
    String users;
    RoommateConnect roommateConnect= new RoommateConnect();
    RoommateAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roommate);

        Intent intent = getIntent();
        users = intent.getStringExtra("Username");

        List<RoommateModel> roommateModels= null;
        try {
            roommateModels = roommateConnect.loadRoommate(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final ListView listView = findViewById(R.id.listviewRoommate);
        adapter= new RoommateAdapter(this,roommateModels);
        listView.setAdapter(adapter);

    }
}
