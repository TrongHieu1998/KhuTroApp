package com.example.khutroapp.ui.screens.fragment_setting.connect;

import android.os.AsyncTask;

import com.example.khutroapp.ui.connect.JDBCController;
import com.example.khutroapp.ui.screens.activity_roommate.model.RoommateModel;
import com.example.khutroapp.ui.screens.fragment_setting.model.SettingModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SettingConnect {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public SettingConnect() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }
    public List<SettingModel> loadSetting (String makt) throws SQLException {
        List<SettingModel> list = new ArrayList<>();

        Statement statement = connection.createStatement();

        String sql ="SELECT TENKT,KHACHTHUE.GIOITINH,SDT,KHACHTHUE.NGAYSINH,KHACHTHUE.QUEQUAN FROM PHONG, KHACHTHUE\n" +
                "WHERE KHACHTHUE.MAPHONG=PHONG.MAPHONG \n" +
                "AND PHONG.MAPHONG=(SELECT PHONG.MAPHONG FROM PHONG, KHACHTHUE \n" +
                "WHERE KHACHTHUE.MAPHONG=PHONG.MAPHONG AND KHACHTHUE.MAKT='"+makt+"')";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            boolean add = list.add(new SettingModel( rs.getString("TENKT"), rs.getDate("NGAYSINH").toString(),
                    rs.getString("GIOITINH"),rs.getString("SDT"),rs.getString("QUEQUAN")
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
