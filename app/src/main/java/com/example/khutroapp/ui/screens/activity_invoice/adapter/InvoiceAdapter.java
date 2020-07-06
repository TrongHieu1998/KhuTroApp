package com.example.khutroapp.ui.screens.activity_invoice.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InvoiceAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList=new ArrayList<>();
    private final List<String> fragmentListTitle= new ArrayList<>();
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] { "Chưa thanh toán", "Đã thanh toán"};
    private Context context;

    public InvoiceAdapter (FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentListTitle.size();
    }
    public void AddFragment (Fragment fragment,String Title)
    {
        fragmentList.add(fragment);
        fragmentListTitle.add(Title);
    }
    public CharSequence getPageTitle (int position){
        return fragmentListTitle.get(position);
    }

    public Object instantiateItem(ViewGroup container, int position) {
        Object object = super.instantiateItem(container, position);
        if (object instanceof Fragment) {
            Fragment fragment = (Fragment) object;
            String tag = fragment.getTag();
        }
        return object;
    }
}
