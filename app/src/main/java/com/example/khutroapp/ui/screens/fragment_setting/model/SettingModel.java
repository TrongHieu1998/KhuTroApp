package com.example.khutroapp.ui.screens.fragment_setting.model;

import android.provider.MediaStore;

public class SettingModel {
    String tenkt,ngaysinh,gioitinh,sdt,quequan;
    byte [] avatar;

    public SettingModel(String tenkt, String ngaysinh, String gioitinh, String sdt, String quequan, byte[] avatar) {
        this.tenkt = tenkt;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.quequan = quequan;
        this.avatar = avatar;
    }

    public SettingModel(String tenkt, String ngaysinh, String gioitinh, String sdt, String quequan) {
        this.tenkt = tenkt;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.quequan = quequan;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
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

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }
}
