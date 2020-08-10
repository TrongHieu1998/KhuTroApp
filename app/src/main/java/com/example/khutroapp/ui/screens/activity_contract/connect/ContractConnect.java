package com.example.khutroapp.ui.screens.activity_contract.connect;

import android.os.AsyncTask;

import com.example.khutroapp.ui.connect.JDBCController;
import com.example.khutroapp.ui.screens.activity_contract.model.ContractModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContractConnect {
    private static final String TAG = "k";
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public ContractConnect() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }
    public List<ContractModel> loadContract (String makt) throws SQLException {
        List<ContractModel> list = new ArrayList<>();

        Statement statement = connection.createStatement();

        String sql ="Select HOPDONG.MAHD, TENKT,TENTANG,TENLOAI,TENPHONG,CONVERT(decimal,TIENCOC, 103) TIENCOC,CONVERT(varchar,NGAYLAPHD, 103) NGAYLAPHD\n" +
                ",CONVERT(varchar,NGAYTRA, 103) NGAYTRA,TINHTRANGHOPDONG\n" +
                "FROM KHACHTHUE, PHONG,HOPDONG,TANG,LOAIPHONG, KHACHTHUEPHONG\n" +
                "WHERE KHACHTHUE.MAKT=KHACHTHUEPHONG.MAKT AND KHACHTHUEPHONG.MAPHONG=PHONG.MAPHONG AND PHONG.MAPHONG=HOPDONG.MAPHONG\n" +
                "AND PHONG.MALOAI=LOAIPHONG.MALOAI AND TANG.MATANG=PHONG.MATANG \n" +
                "AND KHACHTHUE.MAKT=(SELECT KHACHTHUEPHONG.MAKT FROM PHONG, KHACHTHUE, KHACHTHUEPHONG\n" +
                "\t\t\t\t\t WHERE KHACHTHUEPHONG.MAPHONG=PHONG.MAPHONG and KHACHTHUEPHONG.MAKT=KHACHTHUE.MAKT AND\n" +
                "\t\t\t\t\t  KHACHTHUE.TRUONGPHONG='True' AND \n" +
                "\t\t\t\t\t  PHONG.MAPHONG=(SELECT PHONG.MAPHONG FROM PHONG, KHACHTHUEPHONG\n" +
                "\t\t\t\t\tWHERE KHACHTHUEPHONG.MAPHONG=PHONG.MAPHONG AND KHACHTHUEPHONG.MAKT='"+makt+"'))";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            boolean add = list.add(new ContractModel(
                    rs.getString("MAHD"),
                    rs.getString("TENKT"),
                    rs.getString("TENTANG"),
                    rs.getString("TENLOAI"),
                    rs.getString("TENPHONG"),
                    rs.getString("NGAYLAPHD"),
                    rs.getString("NGAYTRA"),
                    rs.getBigDecimal("TIENCOC").toString(),
                    rs.getString("TINHTRANGHOPDONG")));
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
