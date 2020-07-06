package com.example.khutroapp.ui.screens.activity_contract;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_paid.adapter.PaidAdapter;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_paid.connect.PaidConnect;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_paid.model.PaidModel;

import java.sql.SQLException;
import java.util.List;

public class ActivityContract extends AppCompatActivity {
    String users;
    PaidConnect paidConnect= new PaidConnect();
    PaidAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);

        Intent intent = getIntent();
        users = intent.getStringExtra("Username");

        List<PaidModel> paidModels= null;
        try {
            paidModels = paidConnect.loadPaid(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final ListView listView = findViewById(R.id.listview);
        adapter= new PaidAdapter(this,paidModels);
        listView.setAdapter(adapter);
    }
}
