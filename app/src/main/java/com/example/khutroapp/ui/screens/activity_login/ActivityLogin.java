package com.example.khutroapp.ui.screens.activity_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.MainActivity;
import com.example.khutroapp.ui.screens.activity_login.model.UserModel_dangnhap;
import com.example.khutroapp.ui.screens.activity_register.DangKiActivity;

import java.sql.SQLException;

public class ActivityLogin extends AppCompatActivity {
    Button btn_dangki;
    EditText edt_user,edt_pass;
    String user, pass;
    UserModel_dangnhap dn = new UserModel_dangnhap();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_dangki=findViewById(R.id.btn_dangki);
        btn_dangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ActivityLogin.this, DangKiActivity.class);
                startActivity(intent);
            }
        });
    }
    public void dangnhap(View view) {
        edt_user=(EditText) findViewById(R.id.edt_sdt);
        edt_pass=(EditText) findViewById(R.id.edt_password);
        user = edt_user.getText().toString();
        pass = edt_pass.getText().toString();
        if(user.length()==0 || pass.length()==0) {
            Toast.makeText(this, "Vui lòng nhập đủ thông tin" , Toast.LENGTH_LONG).show();
        }
        else {
            try {
                if (dn.kiemtra_user(user, pass)) {
                    Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ActivityLogin.this, MainActivity.class);
                    intent.putExtra("Username", user);///////////////////
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_LONG).show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
