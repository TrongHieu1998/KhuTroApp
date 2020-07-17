package com.example.khutroapp.ui.screenchutro.activity_detailroom.model;

public class DetailKhachThueModel {
    String tenkt,ngaysinh,gioitinh,sdt,quequan;

    public DetailKhachThueModel(String tenkt, String ngaysinh, String gioitinh, String sdt, String quequan) {
        this.tenkt = tenkt;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.quequan = quequan;
    }

    public String getTenkt() {
        return tenkt;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public String getQuequan() {
        return quequan;
    }
}
