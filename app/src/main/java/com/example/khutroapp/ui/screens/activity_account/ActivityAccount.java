package com.example.khutroapp.ui.screens.activity_account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.connect.JDBCController;
import com.example.khutroapp.ui.screens.activity_account.adapter.AccountAdapter;
import com.example.khutroapp.ui.screens.activity_account.connect.AccountConnect;
import com.example.khutroapp.ui.screens.activity_account.model.AccountModel;
import com.example.khutroapp.ui.screens.activity_contract.adapter.ContractAdapter;
import com.example.khutroapp.ui.screens.activity_contract.connect.ContractConnect;
import com.example.khutroapp.ui.screens.activity_contract.model.ContractModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ActivityAccount extends AppCompatActivity {
    String users;
    AccountConnect accountConnect= new AccountConnect();
    AccountAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Intent intent = getIntent();
        users = intent.getStringExtra("Username");

        List<AccountModel> accountModels= null;
        try {
            accountModels = accountConnect.loadAccount(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final ListView listView = findViewById(R.id.listviewAccount);
        adapter= new AccountAdapter(this,accountModels);
        listView.setAdapter(adapter);
    }
}