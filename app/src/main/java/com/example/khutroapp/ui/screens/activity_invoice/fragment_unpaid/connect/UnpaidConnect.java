package com.example.khutroapp.ui.screens.activity_invoice.fragment_unpaid.connect;

import android.os.AsyncTask;

import com.example.khutroapp.ui.connect.JDBCController;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_paid.model.PaidModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UnpaidConnect {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public UnpaidConnect() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }
    public List<PaidModel> loadPaid(String MaHdn) throws SQLException {
        List<PaidModel> list = new ArrayList<>();

        Statement statement = connection.createStatement();

        String sql ="SELECT  KHACHTHUE.MAKT,PHONG.MAPHONG,MAHOADON,THANGNAM,TIENDIEN,TIENNUOC,WIFI,RAC,LOAIPHONG.GIA,TONGTIEN\n" +
                "FROM KHACHTHUE,PHONG, HOADON,LOAIPHONG \n" +
                "WHERE KHACHTHUE.MAPHONG=PHONG.MAPHONG AND PHONG.MAPHONG=HOADON.MAPHONG AND PHONG.MALOAI=LOAIPHONG.MALOAI AND HOADON.TINHTRANG='false' AND MAKT='"+MaHdn+"'";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            boolean add = list.add(new PaidModel(rs.getString("MAPHONG"),rs.getString("MAHOADON"), rs.getString("THANGNAM"),
                    rs.getBigDecimal("TIENDIEN").toString(),rs.getBigDecimal("TIENNUOC").toString(),
                    rs.getBigDecimal("WIFI").toString(),rs.getBigDecimal("RAC").toString(),
                    rs.getBigDecimal("GIA").toString(),rs.getBigDecimal("TONGTIEN").toString()));

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
