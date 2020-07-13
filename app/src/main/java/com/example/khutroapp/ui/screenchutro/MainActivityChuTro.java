package com.example.khutroapp.ui.screenchutro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screenchutro.fragment_home_ct.FragmentHomeCT;
import com.example.khutroapp.ui.screenchutro.fragment_room_ct.FragmentRoomCT;
import com.example.khutroapp.ui.screenchutro.fragment_setting_ct.FragmentSettingCT;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.onesignal.OSPermissionSubscriptionState;
import com.onesignal.OneSignal;

public class MainActivityChuTro extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener  mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener(){
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            return loadFragment(menuItem.getItemId());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chu_tro);




        BottomNavigationView nav = findViewById(R.id.nav_view_chutro);
        nav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(R.id.navigation_home_ct);
    }
    public boolean loadFragment(int id) {
        String backStateName = "Nhà trọ";
        Fragment fragment = null;
        switch (id) {
            case R.id.navigation_setting_ct:
                fragment = FragmentSettingCT.getInstance();
                break;
            case R.id.navigation_room_ct:
                fragment= FragmentRoomCT.getInstance();
                backStateName="Phòng trọ";
                break;
            case R.id.navigation_home_ct:
                fragment = FragmentHomeCT.getInstance();
                backStateName = "Nhà trọ";
                break;
        }
        replaceFragment(fragment,backStateName,id);
        return true;
    }
    public void replaceFragment (Fragment fragment, String backStateName, int i){
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(fragmentManager.findFragmentByTag(backStateName) == null){
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.FrameLayoutChuTro, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }else{
            getSupportFragmentManager().popBackStack(backStateName,i);
        }
    }
}