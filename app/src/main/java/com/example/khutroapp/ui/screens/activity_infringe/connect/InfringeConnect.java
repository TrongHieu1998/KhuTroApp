package com.example.khutroapp.ui.screens.activity_infringe.connect;

import android.os.AsyncTask;

import com.example.khutroapp.ui.connect.JDBCController;
import com.example.khutroapp.ui.screens.activity_indexwater.model.IndexWaterModel;
import com.example.khutroapp.ui.screens.activity_infringe.model.InfringeModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InfringeConnect {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public InfringeConnect() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }
    public List<InfringeModel> loadInfringe(String makt) throws SQLException {
        List<InfringeModel> list = new ArrayList<>();

        Statement statement = connection.createStatement();

        String sql ="SELECT MAVIPHAM,CONVERT(varchar,NGAYVIPHAM, 103) NGAYVIPHAM,TENKT,NOIDUNG,HINHPHAT,NOIQUY.GHICHU\n" +
                "FROM KHACHTHUE,VIPHAM,NOIQUY\n" +
                "WHERE KHACHTHUE.MAKT=VIPHAM.MAKT AND VIPHAM.MANOIQUY=NOIQUY.MANOIQUY AND KHACHTHUE.MAKT='"+makt+"' ";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            boolean add = list.add(new InfringeModel(
                    rs.getString("MAVIPHAM"),
                    rs.getString("NGAYVIPHAM"),
                    rs.getString("TENKT"),
                    rs.getString("NOIDUNG"),
                    rs.getString("HINHPHAT"),
                   rs.getString("GHICHU")));
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
