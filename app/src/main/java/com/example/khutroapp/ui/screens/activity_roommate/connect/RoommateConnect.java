package com.example.khutroapp.ui.screens.activity_roommate.connect;

import android.os.AsyncTask;

import com.example.khutroapp.ui.connect.JDBCController;
import com.example.khutroapp.ui.screens.activity_roommate.model.RoommateModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoommateConnect {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public RoommateConnect() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }
    public List<RoommateModel> loadRoommate (String makt) throws SQLException {
        List<RoommateModel> list = new ArrayList<>();

        Statement statement = connection.createStatement();

        String sql ="SELECT TENKT,KHACHTHUE.GIOITINH,SDT,CONVERT(varchar,KHACHTHUE.NGAYSINH, 103) NGAYSINH,\n" +
                "\t\tKHACHTHUE.QUEQUAN FROM PHONG, KHACHTHUE, KHACHTHUEPHONG\n" +
                "                WHERE KHACHTHUEPHONG.MAPHONG=PHONG.MAPHONG and KHACHTHUEPHONG.MAKT=KHACHTHUE.MAKT\n" +
                "                AND PHONG.MAPHONG=(SELECT PHONG.MAPHONG FROM  PHONG, KHACHTHUE, KHACHTHUEPHONG\n" +
                "                WHERE KHACHTHUEPHONG.MAPHONG=PHONG.MAPHONG and KHACHTHUEPHONG.MAKT=KHACHTHUE.MAKT and\n" +
                "\t\t\t\t KHACHTHUE.MAKT='"+makt+"')\n" +
                "\t\t\t\t and KHACHTHUE.MAKT not in (select KHACHTHUE.MAKT from KHACHTHUE\n" +
                "\t\t\t\t\t\t\t\t\t\t\twhere KHACHTHUE.MAKT='"+makt+"')";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            boolean add = list.add(new RoommateModel( rs.getString("TENKT"), rs.getString("NGAYSINH"),
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
