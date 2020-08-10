package com.example.khutroapp.ui.screenchutro.activity_detailroom.connect;

import android.os.AsyncTask;

import com.example.khutroapp.ui.connect.JDBCController;
import com.example.khutroapp.ui.screenchutro.activity_detailroom.model.DetailHoaDonModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DetailHoaDonConnect {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public DetailHoaDonConnect() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }
    public List<DetailHoaDonModel> loadHoaDon(String tenphong) throws SQLException {
        List<DetailHoaDonModel> list = new ArrayList<>();

        Statement statement = connection.createStatement();

        String sql ="SELECT PHONG.MAPHONG,MAHOADON,CONVERT(varchar,THANGNAM, 103) THANGNAM,CONVERT(decimal,TIENDIEN, 103)TIENDIEN,CONVERT(decimal,TIENNUOC, 103) TIENNUOC,CONVERT(decimal,WIFI, 103) WIFI,CONVERT(decimal,RAC, 103) RAC,CONVERT(decimal,LOAIPHONG.GIA, 103) GIA,CONVERT(decimal,TONGTIEN, 103) TONGTIEN\n" +
                "FROM KHACHTHUEPHONG,PHONG, HOADON,LOAIPHONG\n" +
                "WHERE KHACHTHUEPHONG.MAPHONG=PHONG.MAPHONG AND PHONG.MAPHONG=HOADON.MAPHONG AND PHONG.MALOAI=LOAIPHONG.MALOAI AND HOADON.TINHTRANG='true' AND PHONG.TENPHONG='"+tenphong+"'  ";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            boolean add = list.add(new DetailHoaDonModel(
                    rs.getString("MAHOADON"),
                    rs.getString("THANGNAM"),
                    rs.getString("MAPHONG"),
                    rs.getBigDecimal("TIENDIEN").toString(),
                    rs.getBigDecimal("TIENNUOC").toString(),
                    rs.getBigDecimal("WIFI").toString(),
                    rs.getBigDecimal("RAC").toString(),
                    rs.getBigDecimal("GIA").toString(),
                    rs.getBigDecimal("TONGTIEN").toString()));

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
