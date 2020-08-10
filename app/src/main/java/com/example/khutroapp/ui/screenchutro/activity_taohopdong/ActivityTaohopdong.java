package com.example.khutroapp.ui.screenchutro.activity_taohopdong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.connect.JDBCController;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ActivityTaohopdong extends AppCompatActivity {
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;
    private Button btn_taohopdong;
    private  String maktp,maphong,tenphong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taohopdong);
        final EditText edt_makt=findViewById(R.id.edt_makt);
        final EditText edt_tenkt=findViewById(R.id.edt_tenkt);
        final EditText edt_ngaysinh=findViewById(R.id.edt_ngaysinh);
        final EditText edt_sdt=findViewById(R.id.edt_sdt);
        final EditText edt_socmnd=findViewById(R.id.edt_cmnd);
        final EditText edt_quequan=findViewById(R.id.edt_quequan);
        final EditText edt_ghichu=findViewById(R.id.edt_ghichu);
        btn_taohopdong=findViewById(R.id.btn_taohopdong);

        final EditText edt_madh=findViewById(R.id.edt_mahd);
        final EditText edt_tiencoc=findViewById(R.id.edt_tiencoc);
        final EditText edt_ngaylaphd=findViewById(R.id.edt_ngaylaphd);
        final EditText edt_ngayketthuchd=findViewById(R.id.edt_ngaytrahd);
        connection = jdbcController.ConnnectionData();
        try {
            Statement statement = connection.createStatement();
            String sql ="SELECT dbo.SINHMA_HOPDONG() MAHD";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String mahd=rs.getString(1);
                edt_madh.setText(mahd);
            }
            rs.close();

            String sql1="SELECT dbo.SINHMA_KHACHTHUE() MAKT";
            ResultSet rs1 = statement.executeQuery(sql1);
            while (rs1.next()) {
                String makt=rs1.getString(1);
                edt_makt.setText(makt);
            }
            rs1.close();

            String sql2="SELECT dbo.SINHMA_KTPhong() MAKTP";
            ResultSet rs2 = statement.executeQuery(sql2);
            while (rs2.next()) {
                maktp=rs2.getString(1);
            }
            Bundle bundle=getIntent().getExtras();
            if(bundle!=null) {
                tenphong = bundle.getString("TenPhong");
                String sql3="SELECT MAPHONG FROM PHONG WHERE TENPHONG='"+tenphong+"' ";
                ResultSet rs3 = statement.executeQuery(sql3);
                while (rs3.next()) {
                    maphong=rs3.getString(1);
                }
                btn_taohopdong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Statement statement = connection.createStatement();
                            String sql3 = "Set dateformat dmy INSERT INTO KHACHTHUE(MAKT,TENKT,SDT,QUEQUAN,SOCMND,NGAYSINH,TRUONGPHONG,TINHTRANGTAMTRU,MK,GHICHU,TINHTRANG) " +
                                    "values( '"+edt_makt.getText()+"',N'"+edt_tenkt.getText()+"','"+edt_sdt.getText()+"','"+edt_quequan.getText()+"','"+edt_socmnd.getText()+"','"+edt_ngaysinh.getText()+"'," +
                                    "  'True',N'chưa đăng kí','abc','NULL','True')";

                            String sql4="INSERT INTO KHACHTHUEPHONG(MAKTP,MAPHONG,MAKT) values ('"+maktp+"','"+maphong+"','"+edt_makt.getText().toString()+"') ";

                            String sql5="Set dateformat dmy INSERT INTO HOPDONG(MAHD,TIENCOC,NGAYLAPHD,MANV,NGAYTRA,MAPHONG,TINHTRANG) " +
                                    "values('"+edt_madh.getText()+"','"+edt_tiencoc.getText()+"','"+edt_ngaylaphd.getText()+"','NV001'," +
                                    " '"+edt_ngayketthuchd.getText()+"','"+maphong+"','True')";
                            if (statement.executeUpdate(sql3) > 0 && statement.executeUpdate(sql4)>0 && statement.executeUpdate(sql5)>0) {
                                // Dùng lệnh executeUpdate cho các lệnh CRUD
                                String sql6 = " Update PHONG set TINHTRANG = 'True',SOLUONG_HT= '1'  where MAPHONG= '"+maphong+"'  ";
                                if(statement.executeUpdate(sql6)>0)
                                {
                                    Toast.makeText(ActivityTaohopdong.this, "Thành công", Toast.LENGTH_SHORT).show();
                                }
                                connection.close();
                            } else {
                                Toast.makeText(ActivityTaohopdong.this, "Thất bại", Toast.LENGTH_SHORT).show();
                                connection.close();
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}