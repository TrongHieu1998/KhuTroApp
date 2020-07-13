package com.example.khutroapp.ui.screenchutro.fragment_room_ct.connect;

import android.os.AsyncTask;

import com.example.khutroapp.ui.connect.JDBCController;
import com.example.khutroapp.ui.screenchutro.fragment_room_ct.model.RoomModel;
import com.example.khutroapp.ui.screens.activity_contract.model.ContractModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomConnect {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public RoomConnect() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }
    public List<RoomModel> loadRoom() throws SQLException {
        List<RoomModel> list = new ArrayList<>();

        Statement statement = connection.createStatement();

        String sql ="Select TENPHONG \n" +
                "FROM PHONG " ;
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            boolean add = list.add(new RoomModel( rs.getString("TENPHONG")));
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
