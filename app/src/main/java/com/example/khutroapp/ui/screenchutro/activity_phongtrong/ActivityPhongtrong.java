package com.example.khutroapp.ui.screenchutro.activity_phongtrong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screenchutro.activity_phongtrong.adapter.PhongTrongAdapter;
import com.example.khutroapp.ui.screenchutro.activity_phongtrong.connect.PhongTrongConnect;
import com.example.khutroapp.ui.screenchutro.activity_phongtrong.model.PhongTrongModel;
import com.example.khutroapp.ui.screenchutro.fragment_room_ct.adapter.RoomAdapter;
import com.example.khutroapp.ui.screenchutro.fragment_room_ct.connect.RoomConnect;
import com.example.khutroapp.ui.screenchutro.fragment_room_ct.model.RoomModel;

import java.sql.SQLException;
import java.util.List;

public class ActivityPhongtrong extends AppCompatActivity {
    PhongTrongConnect phongTrongConnect= new PhongTrongConnect();
    PhongTrongAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phongtrong);

        List<PhongTrongModel> phongTrongModels= null;
        try {
            phongTrongModels = phongTrongConnect.loadphongtrong();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final GridView gridView= findViewById(R.id.gridview_phongtrong);
        adapter= new PhongTrongAdapter(this,phongTrongModels);
        gridView.setAdapter(adapter);
    }
}