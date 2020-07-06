package com.example.khutroapp.ui.screens.activity_invoice.fragment_paid.model;

public class PaidModel {
    public String mahdn,thangnam,maphong,tiendien,tiennuoc,tienwifi,tienrac,tienphong,tongtien;

    public PaidModel(String maphong,String mahdn,String thangnam,String tiendien,
                     String tiennuoc, String tienwifi, String tienrac, String tienphong, String tongtien) {
        this.maphong = maphong;
        this.mahdn = mahdn;
        this.thangnam = thangnam;
        this.tiendien = tiendien;
        this.tiennuoc = tiennuoc;
        this.tienwifi = tienwifi;
        this.tienrac = tienrac;
        this.tienphong = tienphong;
        this.tongtien = tongtien;
    }
//    public PaidModel( String maphong,String mahdn,String thangnam, String tiendien) {
//        this.maphong = maphong;
//        this.mahdn = mahdn;
//        this.thangnam = thangnam;
//        this.tiendien = tiendien;
//    }

    public String getThangnam() {
        return thangnam;
    }

    public void setThangnam(String thangnam) {
        this.thangnam = thangnam;
    }

    public String getMahdn() {
        return mahdn;
    }

    public void setMahdn(String mahdn) {
        this.mahdn = mahdn;
    }

    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public String getTiendien() {
        return tiendien;
    }

    public void setTiendien(String tiendien) {
        this.tiendien = tiendien;
    }

    public String getTiennuoc() {
        return tiennuoc;
    }

    public void setTiennuoc(String tiennuoc) {
        this.tiennuoc = tiennuoc;
    }

    public String getTienwifi() {
        return tienwifi;
    }

    public void setTienwifi(String tienwifi) {
        this.tienwifi = tienwifi;
    }

    public String getTienrac() {
        return tienrac;
    }

    public void setTienrac(String tienrac) {
        this.tienrac = tienrac;
    }

    public String getTienphong() {
        return tienphong;
    }

    public void setTienphong(String tienphong) {
        this.tienphong = tienphong;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }
}
