package com.example.khutroapp.ui.screens.activity_contract.connect;

import android.os.AsyncTask;

import com.example.khutroapp.ui.connect.JDBCController;
import com.example.khutroapp.ui.screens.activity_contract.model.ContractModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContractConnect {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public ContractConnect() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }
    public List<ContractModel> loadContract (String makt) throws SQLException {
        List<ContractModel> list = new ArrayList<>();

        Statement statement = connection.createStatement();

        String sql ="Select HOPDONG.MAHD, TENKT,TENTANG,TENLOAI,TENPHONG,TIENCOC,NGAYLAPHD,NGAYTRA,TINHTRANGHOPDONG\n" +
                "fROM KHACHTHUE, PHONG,HOPDONG,TANG,LOAIPHONG \n" +
                "WHERE KHACHTHUE.MAPHONG=PHONG.MAPHONG AND HOPDONG.MAKT=KHACHTHUE.MAKT AND PHONG.MATANG=TANG.MATANG AND PHONG.MALOAI=LOAIPHONG.MALOAI\n" +
                " and KHACHTHUE. MAKT=(SELECT KHACHTHUE.MAKT FROM PHONG, KHACHTHUE\n" +
                "WHERE KHACHTHUE.MAPHONG=PHONG.MAPHONG and\n" +
                "KHACHTHUE.TRUONGPHONG='True'\n" +
                "AND PHONG.MAPHONG=(SELECT PHONG.MAPHONG FROM PHONG, KHACHTHUE \n" +
                "WHERE KHACHTHUE.MAPHONG=PHONG.MAPHONG AND KHACHTHUE.MAKT='"+makt+"'))";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            boolean add = list.add(new ContractModel( rs.getString("MAHD"), rs.getString("TENKT"),
                    rs.getString("TENTANG"),rs.getString("TENLOAI"),rs.getString("TENPHONG"),
                    rs.getDate("NGAYLAPHD").toString(),rs.getDate("NGAYTRA").toString(),rs.getBigDecimal("TIENCOC").toString(),
                    rs.getString("TINHTRANGHOPDONG")));
        }

        connection.close();// Đóng kết nối
        return list;
    }
    private class connect extends AsyncTask<Void,Void,Connection> {

        @Override
        protected Connection doInBackground(Void... voids) {
            connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
            return connection;
        }
    }
}
