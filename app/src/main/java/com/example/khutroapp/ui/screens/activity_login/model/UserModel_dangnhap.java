package com.example.khutroapp.ui.screens.activity_login.model;

import android.os.AsyncTask;
import android.util.Log;

import com.example.khutroapp.ui.connect.JDBCController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserModel_dangnhap {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;
    public UserModel_dangnhap() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }

    public Boolean kiemtra_user(String manv, String pass) throws SQLException {
        boolean result = false;
        List<item_dangnhap> list = new ArrayList<>();
        connection = jdbcController.ConnnectionData();
        String sql = "select MAKT, MK from KHACHTHUE \n" +
                "where MAKT='"+manv+"' and MK='"+pass+"'";
        Statement statement = connection.createStatement();
        // Tạo đối tượng Statement.
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new item_dangnhap(rs.getString("MAKT"), rs.getString("MK")));// Đọc dữ liệu từ ResultSet
        }
        connection.close();// Đóng kết nối
        if(list.size()>0)
            result=true;
        return result;
    }
    private class connect extends AsyncTask<Void, Void, Connection> {

        @Override
        protected Connection doInBackground(Void... voids) {
            connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
            Log.d("a", "UserModel_dangnhap: " + connection);
            return connection;
        }
    }
}


