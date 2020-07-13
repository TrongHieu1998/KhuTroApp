package com.example.khutroapp.ui.screens.activity_invoice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.MainActivity;
import com.example.khutroapp.ui.screens.activity_invoice.adapter.InvoiceAdapter;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_paid.FragmentPaid;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_unpaid.FragmentUnpaid;
import com.google.android.material.tabs.TabLayout;

public class ActivityInvoice extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    String users;
    ImageView img_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);
        Intent intent = getIntent();
        users = intent.getStringExtra("Username");

        img_back=findViewById(R.id.img_backInvoice);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                intent.putExtra("Username", users);
//                startActivity(intent);
            }
        });
        viewPager=findViewById(R.id.viewpager);
        tabLayout=findViewById(R.id.tablayout);
        InvoiceAdapter adapter= new InvoiceAdapter(getSupportFragmentManager());
        adapter.AddFragment(FragmentUnpaid.getInstance(),"Chưa thanh toán");
        adapter.AddFragment(FragmentPaid.getInstance(), "Lịch sử thanh toán");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
