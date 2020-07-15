package com.example.khutroapp.ui.screens.fragment_setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;


import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_login.ActivityLogin;
import com.example.khutroapp.ui.screens.activity_account.ActivityAccount;
import com.example.khutroapp.ui.screens.fragment_setting.adapter.SettingAdapter;
import com.example.khutroapp.ui.screens.fragment_setting.connect.SettingConnect;
import com.example.khutroapp.ui.screens.fragment_setting.model.SettingModel;

import java.sql.SQLException;
import java.util.List;


public class SettingFragment extends Fragment {


    //SettingAdapet1 adapter1;
//    ArrayList<SettingModel> settingModels=new ArrayList<>();

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

    String users;
    ImageView btn_setting,btn_logout;
    SettingAdapter adapter;
    SettingConnect settingConnect = new SettingConnect();
    void mapping(View view){

        Intent intent =getActivity().getIntent();
        users = intent.getStringExtra("Username");
        List<SettingModel> settingModels =null;
        try {
            settingModels = settingConnect.loadSetting(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final ListView listView = view.findViewById(R.id.listviewSetting);
        adapter= new SettingAdapter(getContext(),settingModels);
        listView.setAdapter(adapter);

        btn_setting=view.findViewById(R.id.btn_setting);
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), ActivityAccount.class);
                intent.putExtra("Username", users);
                startActivity(intent);
            }
        });
        btn_logout=view.findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), ActivityLogin.class);
                intent.putExtra("Username", users);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }

}