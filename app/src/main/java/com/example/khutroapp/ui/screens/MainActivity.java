package com.example.khutroapp.ui.screens;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.fragment_home.HomeFragment;
import com.example.khutroapp.ui.screens.fragment_setting.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.onesignal.OSPermissionSubscriptionState;
import com.onesignal.OneSignal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener  mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            return loadFragment(menuItem.getItemId());
        }
    };
    private BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Mai test máy thật
        OSPermissionSubscriptionState state;
        state = OneSignal.getPermissionSubscriptionState();
        Log.d("Hieu",state.getSubscriptionStatus().getUserId());


        nav = findViewById(R.id.nav_view);
        nav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(R.id.navigation_home);
    }
    public boolean loadFragment(int id) {
        String backStateName = "Nhà trọ";
        Fragment fragment = null;
        switch (id) {
            case R.id.navigation_setting:
                fragment = SettingFragment.getInstance();
                backStateName = "Cài đặt";
                break;
            case R.id.navigation_home:
                fragment =HomeFragment.getInstance();
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
            ft.replace(R.id.FrameLayoutMain, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }else{
            getSupportFragmentManager().popBackStack(backStateName,i);
        }
    }

}
