package com.example.khutroapp.ui.screens.activity_account.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_account.model.AccountModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AccountAdapter extends BaseAdapter {

    private Context context;
    public List<AccountModel> listData;
    private LayoutInflater layoutInflater;

    public AccountAdapter(Context context, List<AccountModel> listData) {
        this.context = context;
        this.listData = listData;
        this.layoutInflater = layoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AccountAdapter.ViewHolder holder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.item_account,null);
            holder= new AccountAdapter.ViewHolder();
            holder.img= convertView.findViewById(R.id.img_test);
            convertView.setTag(holder);
        } else {
            holder=(AccountAdapter.ViewHolder)convertView.getTag();
        }
        AccountModel accountModel= this.listData.get(position);
        byte [] recordImage=accountModel.getImage();
        Bitmap bitmap= BitmapFactory.decodeByteArray(recordImage,0,recordImage.length);
        holder.img.setImageBitmap(bitmap);
        return convertView;
    }
    static class ViewHolder{
       ImageView img;
    }
}
