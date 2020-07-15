package com.example.khutroapp.ui.screens.activity_account.connect;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;

import com.example.khutroapp.ui.connect.JDBCController;
import com.example.khutroapp.ui.screens.activity_account.model.AccountModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountConnect  {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public AccountConnect() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }
    public List<AccountModel> loadAccount (String makt) throws SQLException {
        List<AccountModel> list = new ArrayList<>();

        Statement statement = connection.createStatement();

        String sql ="SELECT TENKT,ANH \n" +
                "FROM KHACHTHUE\n" +
                "WHERE KHACHTHUE.MAKT='"+makt+"' ";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            boolean add = list.add(new AccountModel(
                    rs.getString("ANH")
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
