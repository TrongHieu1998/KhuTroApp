package com.example.khutroapp.ui.screenchutro.fragment_setting_ct;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_contract.ActivityContract;
import com.example.khutroapp.ui.screens.activity_indexwater.ActivityIndexWater;
import com.example.khutroapp.ui.screens.activity_infringe.ActivityInfringe;
import com.example.khutroapp.ui.screens.activity_invoice.ActivityInvoice;
import com.example.khutroapp.ui.screens.activity_login.ActivityLogin;
import com.example.khutroapp.ui.screens.activity_roommate.ActivityRoommate;
import com.example.khutroapp.ui.screens.activity_tabernacle.ActivityTabernacle;
import com.example.khutroapp.ui.screens.fragment_home.HomeFragment;
import com.example.khutroapp.ui.screens.fragment_setting.adapter.SettingAdapter;
import com.example.khutroapp.ui.screens.fragment_setting.connect.SettingConnect;
import com.example.khutroapp.ui.screens.fragment_setting.model.SettingModel;

import java.sql.SQLException;
import java.util.List;


public class FragmentSettingCT extends Fragment {

    String users;
    ImageView btn_setting,btn_logout;
    SettingAdapter adapter;
    SettingConnect settingConnect = new SettingConnect();

    public FragmentSettingCT() {
        // Required empty public constructor
    }
    private static FragmentSettingCT instance;

    public static FragmentSettingCT getInstance() {
        if (instance == null) {
            synchronized (FragmentSettingCT.class) {
                if (instance == null) {
                    instance = new FragmentSettingCT();
                }
            }
        }
        return instance;
    }
    View viewRoot;
    private View createView(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_setting_ct, null, false);
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
        Intent intent =getActivity().getIntent();
        users = intent.getStringExtra("Username");
    }


}