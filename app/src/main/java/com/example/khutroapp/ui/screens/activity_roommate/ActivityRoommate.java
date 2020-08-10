package com.example.khutroapp.ui.screens.activity_roommate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_roommate.adapter.RoommateAdapter;
import com.example.khutroapp.ui.screens.activity_roommate.connect.RoommateConnect;
import com.example.khutroapp.ui.screens.activity_roommate.model.RoommateModel;

import java.sql.SQLException;
import java.util.List;

public class ActivityRoommate extends AppCompatActivity {
    String users;
    RoommateConnect roommateConnect= new RoommateConnect();
    RoommateAdapter adapter;
    ImageView img_back;
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
        img_back=findViewById(R.id.img_backRoommate);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
