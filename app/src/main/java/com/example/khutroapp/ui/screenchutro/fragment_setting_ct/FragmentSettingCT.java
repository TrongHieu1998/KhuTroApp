package com.example.khutroapp.ui.screenchutro.fragment_setting_ct;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.connect.JDBCController;
import com.example.khutroapp.ui.screenchutro.activity_login_ct.ActivityLoginCT;
import com.example.khutroapp.ui.screens.activity_account.ActivityAccount;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FragmentSettingCT extends Fragment {


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
    String users;
    ImageView btn_setting,btn_logout;
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;
    void mapping(View view){
        Intent intent =getActivity().getIntent();
        users = intent.getStringExtra("Username");

        final TextView txt_name=view.findViewById(R.id.txt_name_ct);
        final TextView txt_phonenumber=view.findViewById(R.id.txt_phonenumber_ct);
        TextView txt_gender=view.findViewById(R.id.txt_gender_ct);
        final TextView txt_birthday=view.findViewById(R.id.txt_birthday_ct);
        final TextView txt_hometow=view.findViewById(R.id.txt_hometow_ct);
        final ImageView img_avatar=view.findViewById(R.id.img_avatar_ct);

        connection = jdbcController.ConnnectionData();
        try {
            Statement statement = connection.createStatement();
            String sql ="SELECT TENV,CMDN_NV,SODT_CT,CONVERT(varchar,NGAYSINH, 103) NGAYSINH,DIACHI\n" +
                    "FROM NHANVIEN\n" +
                    "WHERE MANV='"+users+"' ";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String hoten=rs.getString(1);
                String gioitinh=rs.getString(2);
                String sdt=rs.getString(3);
                String ngaysinh=rs.getString(4);
                String quequan=rs.getString(5);

                txt_name.setText(hoten);
                txt_phonenumber.setText(sdt);
                txt_gender.setText(gioitinh);
                txt_birthday.setText(ngaysinh);
                txt_hometow.setText(quequan);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        btn_setting=view.findViewById(R.id.btn_setting_ct);
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), ActivityAccount.class);
                intent.putExtra("Username", users);
                intent.putExtra("hoten",txt_name.getText());
                intent.putExtra("sdt",txt_phonenumber.getText());
                intent.putExtra("ngaysinh",txt_birthday.getText());
                intent.putExtra("diachi",txt_hometow.getText());
                startActivity(intent);
            }
        });
        btn_logout=view.findViewById(R.id.btn_logout_ct);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), ActivityLoginCT.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }


}