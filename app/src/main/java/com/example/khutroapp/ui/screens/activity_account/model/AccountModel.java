package com.example.khutroapp.ui.screens.activity_account.model;

import com.bumptech.glide.load.engine.bitmap_recycle.ByteArrayAdapter;

import java.io.ByteArrayInputStream;

public class AccountModel {
    String img;

    public AccountModel(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
