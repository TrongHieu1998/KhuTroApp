package com.example.khutroapp.ui.screens.activity_infringe.model;

public class InfringeModel {
    String mavipham,ngayvipham,tenkt,noidung,hinhphat,ghichu;

    public InfringeModel(String mavipham, String ngayvipham, String tenkt, String noidung, String hinhphat, String ghichu) {
        this.mavipham = mavipham;
        this.ngayvipham = ngayvipham;
        this.tenkt = tenkt;
        this.noidung = noidung;
        this.hinhphat = hinhphat;
        this.ghichu = ghichu;
    }

    public String getMavipham() {
        return mavipham;
    }

    public void setMavipham(String mavipham) {
        this.mavipham = mavipham;
    }

    public String getNgayvipham() {
        return ngayvipham;
    }

    public void setNgayvipham(String ngayvipham) {
        this.ngayvipham = ngayvipham;
    }

    public String getTenkt() {
        return tenkt;
    }

    public void setTenkt(String tenkt) {
        this.tenkt = tenkt;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getHinhphat() {
        return hinhphat;
    }

    public void setHinhphat(String hinhphat) {
        this.hinhphat = hinhphat;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
