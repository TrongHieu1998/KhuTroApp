package com.example.khutroapp.ui.screens.activity_invoice.fragment_unpaid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.fragment_home.HomeFragment;


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
    void mapping(View view){

    }
}
