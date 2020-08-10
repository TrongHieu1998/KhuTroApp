package com.example.khutroapp.ui.screens.activity_changepassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.connect.JDBCController;
import com.example.khutroapp.ui.screens.activity_login.ActivityLogin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ActivityChangePassword extends AppCompatActivity {
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;
    EditText edt_mkmoi,edt_nhaplaimkmoi;
    private String user;
    private Button btn_doimatkhau;
    private ImageView img_back;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        edt_mkmoi=findViewById(R.id.edt_mkmoi);
        edt_nhaplaimkmoi=findViewById(R.id.edt_nhaplaimkmoi);
        btn_doimatkhau=findViewById(R.id.btn_doimatkhau);
        final Intent intent =getIntent();
        user = intent.getStringExtra("Username");
        img_back=findViewById(R.id.img_backChangePass);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btn_doimatkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(edt_mkmoi.getText()))
                {
                    Toast.makeText(ActivityChangePassword.this, "Bạn chưa nhập mật khẩu mới", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(edt_nhaplaimkmoi.getText()))
                {
                    Toast.makeText(ActivityChangePassword.this, "Nhập lại mật khẩu mới", Toast.LENGTH_SHORT).show();
                }
                else if ( edt_nhaplaimkmoi.getText().toString().equals(edt_mkmoi.getText().toString())==false )
                {
                    Toast.makeText(ActivityChangePassword.this, "Nhập lại không trùng khớp", Toast.LENGTH_SHORT).show();
                }
                else {
                    connection = jdbcController.ConnnectionData();
                    try {
                        Statement statement = connection.createStatement();
                        String sql = " Update KHACHTHUE set MK = '"+edt_mkmoi.getText()+"' where MAKT= '"+user+"'  ";
                        if (statement.executeUpdate(sql) > 0) {
                            Toast.makeText(ActivityChangePassword.this, "Thành công", Toast.LENGTH_SHORT).show();
                            connection.close();
                            Intent intent1= new Intent(ActivityChangePassword.this,ActivityLogin.class);
                            startActivity(intent);
                            finish();

                        } else{
                            Toast.makeText(ActivityChangePassword.this, "Thất bại", Toast.LENGTH_SHORT).show();
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