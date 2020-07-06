package com.example.khutroapp.ui.screens.fragment_setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;


import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_infringe.ActivityInfringe;
import com.example.khutroapp.ui.screens.activity_login.ActivityLogin;


public class SettingFragment extends Fragment implements View.OnClickListener {
    public SettingFragment() {
        // Required empty public constructor
    }
    private static SettingFragment instance;

    public static SettingFragment getInstance() {
        if (instance == null) {
            synchronized (SettingFragment.class) {
                if (instance == null) {
                    instance = new SettingFragment();
                }
            }
        }
        return instance;
    }
    View viewRoot;
    private View createView(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_setting, null, false);
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
    ImageView btn_setting,btn_logout;
    void mapping(View view){
        btn_setting=view.findViewById(R.id.btn_setting);
        btn_logout=view.findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(this);
        btn_setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_logout:{
                Intent intent= new Intent(getActivity(), ActivityLogin.class);
                startActivity(intent);
                getActivity().finish();
                break;
            }
            case R.id.btn_setting:{
                break;
            }
        }
    }
}