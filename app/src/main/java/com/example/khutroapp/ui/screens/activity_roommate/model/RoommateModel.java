package com.example.khutroapp.ui.screens.activity_roommate.model;

public class RoommateModel {
    String tenkt,ngaysinh,gioitinh,sdt,quequan;

    public RoommateModel(String tenkt, String ngaysinh,String gioitinh, String sdt, String quequan) {
        this.tenkt = tenkt;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.quequan = quequan;
    }

    public String getTenkt() {
        return tenkt;
    }

    public void setTenkt(String tenkt) {
        this.tenkt = tenkt;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
}
