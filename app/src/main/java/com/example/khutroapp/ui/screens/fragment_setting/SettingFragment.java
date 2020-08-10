package com.example.khutroapp.ui.screens.fragment_setting;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;


import com.example.khutroapp.R;
import com.example.khutroapp.ui.connect.JDBCController;
import com.example.khutroapp.ui.screens.activity_changepassword.ActivityChangePassword;
import com.example.khutroapp.ui.screens.activity_login.ActivityLogin;
import com.example.khutroapp.ui.screens.activity_account.ActivityAccount;
import com.example.khutroapp.ui.screens.fragment_setting.adapter.SettingAdapter;
import com.example.khutroapp.ui.screens.fragment_setting.connect.SettingConnect;
import com.example.khutroapp.ui.screens.fragment_setting.model.SettingModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    ImageView btn_setting,btn_logout,btn_changepass;
    SettingAdapter adapter;
    SettingConnect settingConnect = new SettingConnect();

    private JDBCController jdbcController = new JDBCController();
    private Connection connection;
    void mapping(View view){

        Intent intent =getActivity().getIntent();
        users = intent.getStringExtra("Username");

        final TextView txt_name=view.findViewById(R.id.txt_name);
        final TextView txt_phonenumber=view.findViewById(R.id.txt_phonenumber);
        TextView txt_gender=view.findViewById(R.id.txt_gender);
        final TextView txt_birthday=view.findViewById(R.id.txt_birthday);
        final TextView txt_hometow=view.findViewById(R.id.txt_hometow);
        final ImageView img_avatar=view.findViewById(R.id.img_avatar);

        connection = jdbcController.ConnnectionData();
        try {
            Statement statement = connection.createStatement();
            String sql ="SELECT TENKT,GIOITINH,SDT,CONVERT(varchar,NGAYSINH, 103) NGAYSINH,QUEQUAN,ANH \n" +
                    "FROM KHACHTHUE\n" +
                    "WHERE KHACHTHUE.MAKT='"+users+"' ";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String hoten=rs.getString(1);
                String gioitinh=rs.getString(2);
                String sdt=rs.getString(3);
                String ngaysinh=rs.getString(4);
                String quequan=rs.getString(5);
                byte [] avatar=rs.getBytes(6);

                txt_name.setText(hoten);
                txt_phonenumber.setText(sdt);
                txt_gender.setText(gioitinh);
                txt_birthday.setText(ngaysinh);
                txt_hometow.setText(quequan);

                Bitmap bitmap= BitmapFactory.decodeByteArray(avatar,0,avatar.length);
                img_avatar.setImageBitmap(bitmap);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        btn_setting=view.findViewById(R.id.btn_setting);
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
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

        btn_changepass=view.findViewById(R.id.btn_doimatkhau);
        btn_changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), ActivityChangePassword.class);
                intent.putExtra("Username", users);
                startActivity(intent);
            }
        });

        btn_logout=view.findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), ActivityLogin.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }

}