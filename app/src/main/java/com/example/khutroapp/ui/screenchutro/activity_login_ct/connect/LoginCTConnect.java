package com.example.khutroapp.ui.screenchutro.activity_login_ct.connect;

import android.os.AsyncTask;
import android.util.Log;

import com.example.khutroapp.ui.connect.JDBCController;
import com.example.khutroapp.ui.screens.activity_login.model.item_dangnhap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginCTConnect {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;
    public LoginCTConnect() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }

    public Boolean kiemtra_login(String manv, String pass) throws SQLException {
        boolean result = false;
        List<item_dangnhap> list = new ArrayList<>();
        connection = jdbcController.ConnnectionData();
        String sql = "select MANV, CMND_NV from NHANVIEN \n" +
                "where MANV='"+manv+"' and CMND_NV='"+pass+"'";
        Statement statement = connection.createStatement();
        // Tạo đối tượng Statement.
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new item_dangnhap(rs.getString("MANV"), rs.getString("CMND_NV")));// Đọc dữ liệu từ ResultSet
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
            return connection;
        }
    }
}
