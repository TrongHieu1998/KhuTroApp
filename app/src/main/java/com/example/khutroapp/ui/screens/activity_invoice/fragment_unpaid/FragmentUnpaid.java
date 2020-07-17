package com.example.khutroapp.ui.screens.activity_invoice.fragment_unpaid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_paid.adapter.PaidAdapter;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_paid.connect.PaidConnect;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_paid.model.PaidModel;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_unpaid.adapter.UnpaidAdapter;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_unpaid.connect.UnpaidConnect;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_unpaid.model.UnpaidModel;
import com.example.khutroapp.ui.screens.fragment_home.HomeFragment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FragmentUnpaid extends Fragment {


    public FragmentUnpaid() {
        // Required empty public constructor
    }
    private static FragmentUnpaid instance;

    public static FragmentUnpaid getInstance() {
        if (instance == null) {
            synchronized (FragmentUnpaid.class) {
                if (instance == null) {
                    instance = new FragmentUnpaid();
                }
            }
        }
        return instance;
    }

    View viewRoot;
    private View createView(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_unpaid, null, false);
        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        viewRoot = createView(savedInstanceState);
        super.onCreate(savedInstanceState);
        mapping(viewRoot);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return viewRoot;
    }
    String users;
    UnpaidConnect unpaidConnect= new UnpaidConnect();
    UnpaidAdapter adapter;
    void mapping(View view){
        Intent intent = getActivity().getIntent();
        users = intent.getStringExtra("Username");
        List<UnpaidModel> unpaidModels= new ArrayList<>();
        try {
            unpaidModels= unpaidConnect.loadUnPaid(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final ListView listView = view.findViewById(R.id.listviewUnPaid);
        adapter= new UnpaidAdapter(getContext(),unpaidModels);
        listView.setAdapter(adapter);
    }
}
