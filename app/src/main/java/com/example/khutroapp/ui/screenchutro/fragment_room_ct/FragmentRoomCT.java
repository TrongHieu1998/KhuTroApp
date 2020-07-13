package com.example.khutroapp.ui.screenchutro.fragment_room_ct;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screenchutro.fragment_room_ct.adapter.RoomAdapter;
import com.example.khutroapp.ui.screenchutro.fragment_room_ct.connect.RoomConnect;
import com.example.khutroapp.ui.screenchutro.fragment_room_ct.model.RoomModel;
import com.example.khutroapp.ui.screenchutro.fragment_setting_ct.FragmentSettingCT;
import com.example.khutroapp.ui.screens.activity_contract.adapter.ContractAdapter;
import com.example.khutroapp.ui.screens.activity_contract.model.ContractModel;

import java.sql.SQLException;
import java.util.List;


public class FragmentRoomCT extends Fragment {

    public FragmentRoomCT() {
        // Required empty public constructor
    }
    private static FragmentRoomCT  instance;

    public static FragmentRoomCT getInstance() {
        if (instance == null) {
            synchronized (FragmentRoomCT.class) {
                if (instance == null) {
                    instance = new FragmentRoomCT ();
                }
            }
        }
        return instance;
    }
    View viewRoot;
    private View createView(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_room_ct, null, false);
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
    String users="NV001";
    RoomConnect roomConnect= new RoomConnect();
    RoomAdapter adapter;
    void mapping(View view){
//        Intent intent =getActivity().getIntent();
//        users = intent.getStringExtra("Username");

        List<RoomModel> roomModels= null;
        try {
            roomModels = roomConnect.loadRoom();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final GridView gridView= view.findViewById(R.id.gridview_room);
        adapter= new RoomAdapter(getContext(),roomModels);
        gridView.setAdapter(adapter);
    }
}