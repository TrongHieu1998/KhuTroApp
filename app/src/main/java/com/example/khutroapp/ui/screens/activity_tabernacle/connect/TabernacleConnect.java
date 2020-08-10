package com.example.khutroapp.ui.screens.activity_tabernacle.connect;

import android.os.AsyncTask;

import com.example.khutroapp.ui.connect.JDBCController;
import com.example.khutroapp.ui.screens.activity_tabernacle.model.TabernacleModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TabernacleConnect {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public TabernacleConnect() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }
    public List<TabernacleModel> loadTabernacle (String makt) throws SQLException {
        List<TabernacleModel> list = new ArrayList<>();

        Statement statement = connection.createStatement();

        String sql ="SELECT MATAMTRU,TENKT,CONVERT(varchar,NGAYLAMGIAY, 103) NGAYLAMGIAY,CONVERT(varchar,NGAYHETHAN_TAMTRU, 103) NGAYHETHAN_TAMTRU,QUANHEVOICHUTRO\n" +
                "FROM TAMTRU, KHACHTHUE\n" +
                "WHERE KHACHTHUE.MAKT=TAMTRU.MAKT AND KHACHTHUE.MAKT='"+makt+"' ";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            boolean add = list.add(new TabernacleModel(
                    rs.getString("MATAMTRU"),
                    rs.getString("TENKT"),
                    rs.getString("NGAYLAMGIAY"),
                    rs.getString("NGAYHETHAN_TAMTRU"),
                    rs.getString("QUANHEVOICHUTRO")
            ));
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
