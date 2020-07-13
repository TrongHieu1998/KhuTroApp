package com.example.khutroapp.ui.screens.activity_login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.MainActivity;
import com.example.khutroapp.ui.screens.activity_login.model.UserModel_dangnhap;
import com.example.khutroapp.ui.screens.activity_register.DangKiActivity;
import com.onesignal.OSPermissionSubscriptionState;
import com.onesignal.OneSignal;

import java.sql.SQLException;

public class ActivityLogin extends AppCompatActivity {
    Button btn_dangki;
    EditText edt_user,edt_pass;
    String user, pass;
    CheckBox checkBox_ghinho;
    private ProgressDialog loaddingBar;
    UserModel_dangnhap dn = new UserModel_dangnhap();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();


        loaddingBar= new ProgressDialog(this);
        checkBox_ghinho=findViewById(R.id.checkbox_ghinho);
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
        if(TextUtils.isEmpty(user))
        {
            Toast.makeText(this, "Bạn chưa nhập tên đăng nhập", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(pass))
        {
            Toast.makeText(this, "Bạn chưa nhập mật khẩu", Toast.LENGTH_SHORT).show();
        }
        else {
            try {
//                if (checkBox_ghinho.isChecked())
//                {
//                    Paper.book().write(Prevalent.User,user);
//                    Paper.book().write(Prevalent.PASS,pass);
//                }

//                loaddingBar.setTitle("Đăng nhập");
//                loaddingBar.setMessage("Vui lòng chờ trong giây lát, chúng tôi đang kiểm tra");
//                loaddingBar.setCanceledOnTouchOutside(false);
//                loaddingBar.show();
                if (dn.kiemtra_user(user, pass)) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent= new Intent(ActivityLogin.this,MainActivity.class);
                            intent.putExtra("Username", user);
                            startActivity(intent);
                            finish();
                        }
                    },1000);
//                    OSPermissionSubscriptionState state;
//                    state = OneSignal.getPermissionSubscriptionState();
//                    Log.d("Hieu",state.getSubscriptionStatus().getUserId());
                    Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(ActivityLogin.this, MainActivity.class);
//
//                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_LONG).show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
