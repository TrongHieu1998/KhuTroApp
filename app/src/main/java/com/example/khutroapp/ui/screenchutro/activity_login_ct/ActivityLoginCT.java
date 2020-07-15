package com.example.khutroapp.ui.screenchutro.activity_login_ct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screenchutro.MainActivityChuTro;
import com.example.khutroapp.ui.screenchutro.activity_login_ct.connect.LoginCTConnect;
import com.example.khutroapp.ui.screens.MainActivity;
import com.example.khutroapp.ui.screens.activity_login.ActivityLogin;
import com.onesignal.OneSignal;

import java.sql.SQLException;

public class ActivityLoginCT extends AppCompatActivity {
    Button btn_dangki;
    EditText edt_user,edt_pass;
    String user, pass;
    LoginCTConnect dn= new LoginCTConnect();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ct);
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }
    public void dangnhapCT(View view) {
            edt_user=(EditText) findViewById(R.id.edt_manv);
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
//                loaddingBar.setTitle("Đăng nhập");
//                loaddingBar.setMessage("Vui lòng chờ trong giây lát, chúng tôi đang kiểm tra");
//                loaddingBar.setCanceledOnTouchOutside(false);
//                loaddingBar.show();
                    if (dn.kiemtra_login(user, pass)) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent= new Intent(ActivityLoginCT.this, MainActivityChuTro.class);
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