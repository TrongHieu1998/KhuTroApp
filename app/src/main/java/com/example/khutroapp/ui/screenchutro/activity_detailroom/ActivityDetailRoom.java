package com.example.khutroapp.ui.screenchutro.activity_detailroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screenchutro.activity_detailroom.adapter.DetailHoaDonAdapter;
import com.example.khutroapp.ui.screenchutro.activity_detailroom.adapter.DetailKhachThueAdapter;
import com.example.khutroapp.ui.screenchutro.activity_detailroom.connect.DetailHoaDonConnect;
import com.example.khutroapp.ui.screenchutro.activity_detailroom.connect.DetailKhachThueConnect;
import com.example.khutroapp.ui.screenchutro.activity_detailroom.model.DetailHoaDonModel;
import com.example.khutroapp.ui.screenchutro.activity_detailroom.model.DetailKhachThueModel;
import com.example.khutroapp.ui.screenchutro.fragment_room_ct.adapter.RoomAdapter;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_paid.adapter.PaidAdapter;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_paid.model.PaidModel;
import com.example.khutroapp.ui.screens.activity_roommate.adapter.RoommateAdapter;
import com.example.khutroapp.ui.screens.activity_roommate.model.RoommateModel;

import java.sql.SQLException;
import java.util.List;

public class ActivityDetailRoom extends AppCompatActivity {
    DetailKhachThueConnect detailKhachThueConnect= new DetailKhachThueConnect();
    DetailHoaDonConnect detailHoaDonConnect= new DetailHoaDonConnect();
    DetailKhachThueAdapter adapter ;
    DetailHoaDonAdapter adapter1;
    String tenphong;
    TextView txt_tenphong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_room);
        txt_tenphong=findViewById(R.id.txt_tenphong);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            tenphong=bundle.getString("TenPhong");
            Log.d("HHHHH", "onCreate: "+tenphong);
            List<DetailKhachThueModel> detailKhachThueModels= null;
            try {
                detailKhachThueModels = detailKhachThueConnect.loadDetailKT(tenphong);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            final ListView listView = findViewById(R.id.listview_detail_khachthue);
            adapter= new DetailKhachThueAdapter(this,detailKhachThueModels);
            listView.setAdapter(adapter);





            List<DetailHoaDonModel> detailHoaDonModels= null;
            try {
                detailHoaDonModels = detailHoaDonConnect.loadHoaDon(tenphong);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            final ListView listView1 = findViewById(R.id.listview_detail_Hoadon);
            adapter1= new DetailHoaDonAdapter(this,detailHoaDonModels);
            listView1.setAdapter(adapter1);

    }
//        Intent intent = getIntent();
//        maphong = intent.getStringExtra("TenPhong");


    }
}