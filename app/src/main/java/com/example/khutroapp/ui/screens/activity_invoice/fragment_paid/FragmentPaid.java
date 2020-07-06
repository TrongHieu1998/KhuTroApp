package com.example.khutroapp.ui.screens.activity_invoice.fragment_paid;

import android.content.Intent;
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

import java.sql.SQLException;
import java.util.List;


public class FragmentPaid extends Fragment {

    public FragmentPaid() {
        // Required empty public constructor
    }
    private static FragmentPaid instance;

    public static FragmentPaid getInstance() {
        if (instance == null) {
            synchronized (FragmentPaid.class) {
                if (instance == null) {
                    instance = new FragmentPaid();
                }
            }
        }
        return instance;
    }

    View viewRoot;
    private View createView(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_paid, null, false);
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
    PaidConnect paidConnect= new PaidConnect();
    PaidAdapter adapter;
    void mapping(View view){
        Intent intent = getActivity().getIntent();
        users = intent.getStringExtra("Username");
        List<PaidModel> paidModels= null;
        try {
            paidModels = paidConnect.loadPaid(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final ListView listView = view.findViewById(R.id.listviewPaid);
        adapter= new PaidAdapter(getContext(),paidModels);
        listView.setAdapter(adapter);
    }

}
