package com.example.khutroapp.ui.screens.activity_account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.connect.JDBCController;
import com.example.khutroapp.ui.screens.activity_account.adapter.AccountAdapter;
import com.example.khutroapp.ui.screens.activity_account.connect.AccountConnect;
import com.example.khutroapp.ui.screens.activity_account.model.AccountModel;
import com.example.khutroapp.ui.screens.activity_changepassword.ActivityChangePassword;
import com.example.khutroapp.ui.screens.activity_contract.adapter.ContractAdapter;
import com.example.khutroapp.ui.screens.activity_contract.connect.ContractConnect;
import com.example.khutroapp.ui.screens.activity_contract.model.ContractModel;
import com.example.khutroapp.ui.screens.activity_login.ActivityLogin;
import com.example.khutroapp.ui.screens.fragment_setting.SettingFragment;

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

    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    private EditText edt_hoten,edt_sdt,edt_ngaysinh,edt_diachi;
    private ImageView img_avatar,img_back;
    private Button btn_capnhat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Intent intent = getIntent();
        users = intent.getStringExtra("Username");
        btn_capnhat=findViewById(R.id.btn_capnhatthongtin);
        img_back=findViewById(R.id.img_backAcount);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        edt_hoten=findViewById(R.id.edt_hoten);
        edt_sdt=findViewById(R.id.edt_sdt);
        edt_ngaysinh=findViewById(R.id.edt_ngaysinh);
        edt_diachi=findViewById(R.id.edt_diachi);
        img_avatar=findViewById(R.id.profile_image);

        edt_hoten.setText(intent.getStringExtra("hoten"));
        edt_sdt.setText(intent.getStringExtra("sdt"));
        edt_ngaysinh.setText(intent.getStringExtra("ngaysinh"));
        edt_diachi.setText(intent.getStringExtra("diachi"));

        connection = jdbcController.ConnnectionData();
        try {
            Statement statement = connection.createStatement();
            String sql ="SELECT TENKT,GIOITINH,SDT,NGAYSINH,QUEQUAN,ANH \n" +
                    "FROM KHACHTHUE\n" +
                    "WHERE KHACHTHUE.MAKT='"+users+"' ";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                byte [] avatar=rs.getBytes(6);
                Bitmap bitmap= BitmapFactory.decodeByteArray(avatar,0,avatar.length);
                img_avatar.setImageBitmap(bitmap);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        btn_capnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(edt_hoten.getText()))
                {
                    Toast.makeText(ActivityAccount.this, "Bạn chưa nhập mật họ tên", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(edt_sdt.getText()))
                {
                    Toast.makeText(ActivityAccount.this, "Bạn chưa nhập số điện thoại", Toast.LENGTH_SHORT).show();
                }
                else if ( TextUtils.isEmpty(edt_ngaysinh.getText()))
                {
                    Toast.makeText(ActivityAccount.this, "Bạn chưa nhập ngày sinh", Toast.LENGTH_SHORT).show();
                }
                else if ( TextUtils.isEmpty(edt_diachi.getText()))
                {
                    Toast.makeText(ActivityAccount.this, "Bạn chưa nhập địa chỉ", Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        Statement statement=connection.createStatement();
                        String sql = " Update KHACHTHUE set TENKT = N'"+edt_hoten.getText()+"',SDT= '"+edt_sdt.getText()+"',QUEQUAN= '"+edt_diachi.getText()+"'   where MAKT= '"+users+"'  ";
//                                "SDT= '"+edt_sdt.getText()+"',  " +
//                                "NGAYSINH='"+edt_ngaysinh.getText()+"', " +
//                                "QUEQUAN= '"+edt_diachi.getText()+"'  where MAKT= '"+users+"'  ";
                        if(statement.executeUpdate(sql)>0)
                        {
                            Toast.makeText(ActivityAccount.this, "Thành công", Toast.LENGTH_SHORT).show();
                            connection.close();
                            onBackPressed();
                        }
                        else {
                            Toast.makeText(ActivityAccount.this, "Thất bại", Toast.LENGTH_SHORT).show();
                            connection.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

    }
}