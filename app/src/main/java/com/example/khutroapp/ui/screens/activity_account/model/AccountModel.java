package com.example.khutroapp.ui.screens.activity_account.model;

import com.bumptech.glide.load.engine.bitmap_recycle.ByteArrayAdapter;

import java.io.ByteArrayInputStream;

public class AccountModel {
    byte [] image;

    public AccountModel(byte[] image) {
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
