package com.example.khutroapp.ui.screens.activity_invoice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_invoice.adapter.InvoiceAdapter;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_paid.FragmentPaid;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_unpaid.FragmentUnpaid;
import com.google.android.material.tabs.TabLayout;

public class ActivityInvoice extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);
        viewPager=findViewById(R.id.viewpager);
        tabLayout=findViewById(R.id.tablayout);
        InvoiceAdapter adapter= new InvoiceAdapter(getSupportFragmentManager());
        adapter.AddFragment(FragmentUnpaid.getInstance(),"Chưa thanh toán");
        adapter.AddFragment(FragmentPaid.getInstance(), "Lịch sử thanh toán");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
