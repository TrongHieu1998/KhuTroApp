package com.example.khutroapp.ui.screenchutro.activity_thongkedoanhthu;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.connect.JDBCController;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class ActivityThongkedoanhthu extends AppCompatActivity {
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;
    TextView txt_tongtiencoc,txt_ttdien,txt_ttnuoc,txt_ttwifi,txt_ttracc,txt_ttphong,txt_ttvipham,txt_tongdoanhthu,txt_tongno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongkedoanhthu);

        txt_ttwifi=findViewById(R.id.txt_tongtienwifi);
        txt_tongtiencoc=findViewById(R.id.txt_tongtiencoc);
        txt_ttdien=findViewById(R.id.txt_tongtiendien);
        txt_ttnuoc=findViewById(R.id.txt_tongtiennuoc);
        txt_ttracc=findViewById(R.id.txt_tongtienrac);
        txt_ttphong=findViewById(R.id.txt_tongtienphong);
        txt_ttvipham=findViewById(R.id.txt_tongtienvipham);
        txt_tongno=findViewById(R.id.txt_tongno);
        txt_tongdoanhthu=findViewById(R.id.txt_tongdanhthu);


        String tongtienwifi, tongtiendien,tongtiennuoc, tongtienrac,tongtiencoc,tongtienphong,tongtienvipham,tongtienno;
        connection = jdbcController.ConnnectionData();
        try {
            Statement statement = connection.createStatement();
            String sql ="select CONVERT(decimal,SUM(HOADON.WIFI), 105) TONGTIENWIFI," +
                    "CONVERT(decimal,SUM(HOADON.TIENDIEN), 105) TONGTIENDIEN, " +
                    "CONVERT(decimal,SUM(HOADON.TIENNUOC), 105) TONGTIENNUOC, " +
                    "CONVERT(decimal,SUM(HOADON.RAC), 105) TONGTIENRAC  from HOADON ";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
               tongtienwifi=rs.getString(1);
               tongtiendien=rs.getString(2);
               tongtiennuoc=rs.getString(3);
               tongtienrac=rs.getString(4);

                txt_ttwifi.setText(tongtienwifi);
                txt_ttdien.setText(tongtiendien);
                txt_ttnuoc.setText(tongtiennuoc);
                txt_ttracc.setText(tongtienrac);

            }
            rs.close();

            String sql1="select CONVERT(decimal, SUM(HOPDONG.TIENCOC), 105) TONGTIEN from HOPDONG";
            ResultSet rs1=statement.executeQuery(sql1);
            while (rs1.next()){
                tongtiencoc=rs1.getString(1);
                txt_tongtiencoc.setText(tongtiencoc);
            }
            rs1.close();

            String sql2="select CONVERT(decimal, SUM(LOAIPHONG.GIA),105) TONGTIEN from HOADON ,PHONG, LOAIPHONG where HOADON.MAPHONG=PHONG.MAPHONG and LOAIPHONG.MALOAI=PHONG.MALOAI";
            ResultSet rs2=statement.executeQuery(sql2);
            while (rs2.next()){
                tongtienphong=rs2.getString(1);
                txt_ttphong.setText(tongtienphong);
            }
            rs2.close();

            String sql3="select CONVERT(decimal, SUM(VIPHAM.TIENPHAT), 105) TONGTIEN from VIPHAM ";
            ResultSet rs3=statement.executeQuery(sql3);
            while (rs3.next()){
                tongtienvipham=rs3.getString(1);
                txt_ttvipham.setText(tongtienvipham);
            }
            rs3.close();

            String sql4="select CONVERT(decimal, SUM(VIPHAM.TIENPHAT), 105) TONGTIEN from VIPHAM ";
            ResultSet rs4=statement.executeQuery(sql4);
            while (rs4.next()){
                tongtienno=rs4.getString(1);
                txt_tongno.setText(tongtienno);
            }
            rs4.close();

            Integer ttdien=Integer.parseInt(txt_ttdien.getText().toString());
            Integer ttcoc=Integer.parseInt(txt_tongtiencoc.getText().toString());
            Integer ttnuoc=Integer.parseInt(txt_ttnuoc.getText().toString());
            Integer ttwifi=Integer.parseInt(txt_ttwifi.getText().toString());
            Integer ttrac=Integer.parseInt(txt_ttracc.getText().toString());
            Integer ttphong=Integer.parseInt(txt_ttphong.getText().toString());
//            Integer ttvipham=Integer.parseInt(txt_ttvipham.getText().toString());
            Integer tt=ttdien+ttcoc+ttnuoc+ttwifi+ttrac+ttphong;
            txt_tongdoanhthu.setText(tt.toString());

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}