package com.example.khutroapp.ui.screenchutro.activity_detailroom.connect;

import android.os.AsyncTask;

import com.example.khutroapp.ui.connect.JDBCController;
import com.example.khutroapp.ui.screenchutro.activity_detailroom.model.DetailKhachThueModel;
import com.example.khutroapp.ui.screens.activity_indexwater.model.IndexWaterModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DetailKhachThueConnect {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public DetailKhachThueConnect() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }
    public List<DetailKhachThueModel> loadDetailKT (String tenphong) throws SQLException {
        List<DetailKhachThueModel> list = new ArrayList<>();

        Statement statement = connection.createStatement();

        String sql ="SELECT TENKT,CONVERT(varchar,NGAYSINH, 103) NGAYSINH,GIOITINH,SDT,QUEQUAN\n" +
                "FROM KHACHTHUE,PHONG,KHACHTHUEPHONG\n" +
                "WHERE KHACHTHUEPHONG.MAPHONG=PHONG.MAPHONG AND KHACHTHUE.MAKT=KHACHTHUEPHONG.MAKT AND TENPHONG='"+tenphong+"'";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            boolean add = list.add(new DetailKhachThueModel(
                    rs.getString("TENKT"),
                    rs.getString("NGAYSINH"),
                    rs.getString("GIOITINH"),
                    rs.getString("SDT"),
                    rs.getString("QUEQUAN") ));
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
