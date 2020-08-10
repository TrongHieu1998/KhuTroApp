package com.example.khutroapp.ui.screens.activity_indexwater.connect;

import android.os.AsyncTask;

import com.example.khutroapp.ui.connect.JDBCController;
import com.example.khutroapp.ui.screens.activity_indexwater.model.IndexWaterModel;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_paid.model.PaidModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IndexWaterConnect {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public IndexWaterConnect() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }
    public List<IndexWaterModel> loadIndexWater(String makt) throws SQLException {
        List<IndexWaterModel> list = new ArrayList<>();

        Statement statement = connection.createStatement();

        String sql ="SELECT  CONVERT(varchar,THANGNAM, 103) THANGNAM,SODIENCU,SODIENMOI,SODIEN,SONUOCCU,SONUOCMOI,SONUOC\n" +
                "FROM PHONG,KHACHTHUEPHONG, HOADON,CHISO_DIENNUOC \n" +
                "WHERE KHACHTHUEPHONG.MAPHONG=PHONG.MAPHONG AND PHONG.MAPHONG=HOADON.MAPHONG AND HOADON.MAHOADON=CHISO_DIENNUOC.MAHOADON AND MAKT='"+makt+"'";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            boolean add = list.add(new IndexWaterModel(
                    rs.getString("THANGNAM"),
                    rs.getString("SODIENCU"),
                    rs.getString("SODIENMOI"),
                    rs.getString("SODIEN"),
                    rs.getString("SONUOCCU"),
                    rs.getString("SONUOCMOI"),
                    rs.getString("SONUOC") ));
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
