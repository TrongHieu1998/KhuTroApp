package com.example.khutroapp.ui.screens.activity_contract.model;

public class ContractModel {
    String mahd,tennguoiki,tentang,tenphong,loaiphong,ngaylap,ngayhethan,tiencoc,tinhtrang;

    public ContractModel(String mahd, String tennguoiki, String tentang, String tenphong, String loaiphong, String ngaylap, String ngayhethan, String tiencoc, String tinhtrang) {
        this.mahd = mahd;
        this.tennguoiki = tennguoiki;
        this.tentang = tentang;
        this.tenphong = tenphong;
        this.loaiphong = loaiphong;
        this.ngaylap = ngaylap;
        this.ngayhethan = ngayhethan;
        this.tiencoc = tiencoc;
        this.tinhtrang = tinhtrang;
    }

//    public ContractModel(String tennguoiki, String tentang, String loaiphong, String tenphong,String tinhtrang) {
//        this.tennguoiki = tennguoiki;
//        this.tentang = tentang;
//        this.loaiphong = loaiphong;
//        this.tenphong = tenphong;
//        this.ngaylap = ngaylap;
//        this.ngayhethan = ngayhethan;
//        this.tiencoc = tiencoc;
//        this.tinhtrang = tinhtrang;
 //   }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getTennguoiki() {
        return tennguoiki;
    }

    public void setTennguoiki(String tennguoiki) {
        this.tennguoiki = tennguoiki;
    }

    public String getTentang() {
        return tentang;
    }

    public void setTentang(String tentang) {
        this.tentang = tentang;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public String getLoaiphong() {
        return loaiphong;
    }

    public void setLoaiphong(String loaiphong) {
        this.loaiphong = loaiphong;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public String getNgayhethan() {
        return ngayhethan;
    }

    public void setNgayhethan(String ngayhethan) {
        this.ngayhethan = ngayhethan;
    }

    public String getTiencoc() {
        return tiencoc;
    }

    public void setTiencoc(String tiencoc) {
        this.tiencoc = tiencoc;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
}
