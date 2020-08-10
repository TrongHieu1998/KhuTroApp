package com.example.khutroapp.ui.screens.activity_contract;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_contract.adapter.ContractAdapter;
import com.example.khutroapp.ui.screens.activity_contract.connect.ContractConnect;
import com.example.khutroapp.ui.screens.activity_contract.model.ContractModel;

import java.sql.SQLException;
import java.util.List;

public class ActivityContract extends AppCompatActivity {
    String users;
    ContractConnect contractConnect= new ContractConnect();
    ContractAdapter adapter;
    ImageView img_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);

        Intent intent = getIntent();
        users = intent.getStringExtra("Username");

        List<ContractModel> contractModels= null;
        try {
            contractModels = contractConnect.loadContract(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final ListView listView = findViewById(R.id.listviewContract);
        adapter= new ContractAdapter(this,contractModels);
        listView.setAdapter(adapter);
        img_back=findViewById(R.id.img_backContract);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
