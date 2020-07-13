package com.example.khutroapp.ui.screens.activity_tabernacle.model;

public class TabernacleModel {
    String matt,tenkt,ngatlamgiay,ngayhethan,quanhechutro;

    public TabernacleModel(String matt, String tenkt, String ngatlamgiay, String ngayhethan, String quanhechutro) {
        this.matt = matt;
        this.tenkt = tenkt;
        this.ngatlamgiay = ngatlamgiay;
        this.ngayhethan = ngayhethan;
        this.quanhechutro = quanhechutro;
    }

    public String getMatt() {
        return matt;
    }

    public void setMatt(String matt) {
        this.matt = matt;
    }

    public String getTenkt() {
        return tenkt;
    }

    public void setTenkt(String tenkt) {
        this.tenkt = tenkt;
    }

    public String getNgatlamgiay() {
        return ngatlamgiay;
    }

    public void setNgatlamgiay(String ngatlamgiay) {
        this.ngatlamgiay = ngatlamgiay;
    }

    public String getNgayhethan() {
        return ngayhethan;
    }

    public void setNgayhethan(String ngayhethan) {
        this.ngayhethan = ngayhethan;
    }

    public String getQuanhechutro() {
        return quanhechutro;
    }

    public void setQuanhechutro(String quanhechutro) {
        this.quanhechutro = quanhechutro;
    }
}
