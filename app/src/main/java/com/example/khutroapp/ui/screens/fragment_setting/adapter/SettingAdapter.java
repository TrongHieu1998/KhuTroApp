package com.example.khutroapp.ui.screens.fragment_setting.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.fragment_setting.model.SettingModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SettingAdapter extends BaseAdapter {

    private Context context;
    public List<SettingModel> listData;
    private LayoutInflater layoutInflater;

    public SettingAdapter(Context context, List<SettingModel> listData) {
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
        SettingAdapter.ViewHolder hoder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.fragment_setting,null);
            hoder= new SettingAdapter.ViewHolder();
            hoder.hoten=(TextView) convertView.findViewById(R.id.txt_name);
            hoder.ngaysinh=(TextView)convertView.findViewById(R.id.txt_birthday);
            hoder.gioitinh=(TextView)convertView.findViewById(R.id.txt_gender);
            hoder.sdt=(TextView) convertView.findViewById(R.id.txt_phonenumber);
            hoder.quequan=(TextView) convertView.findViewById(R.id.txt_hometow);
            hoder.avatar=convertView.findViewById(R.id.img_avatar);
            convertView.setTag(hoder);
        } else {
            hoder=(SettingAdapter.ViewHolder)convertView.getTag();
        }
        SettingModel settingModell= this.listData.get(position);

        hoder.hoten.setText(settingModell.getTenkt());
        hoder.ngaysinh.setText(settingModell.getNgaysinh());
        hoder.gioitinh.setText(settingModell.getGioitinh());
        hoder.sdt.setText(settingModell.getSdt());
        hoder.quequan.setText(settingModell.getQuequan());
        byte [] recordImage=settingModell.getAvatar();
        Bitmap bitmap= BitmapFactory.decodeByteArray(recordImage,0,recordImage.length);
        hoder.avatar.setImageBitmap(bitmap);
//        Glide.with(context)
//                .load(settingModell.getAvatar())
//                .into(hoder.avatar);
//        Picasso.get().load(settingModell.getAvatar()).into(hoder.avatar);
        return convertView;
    }
    static class ViewHolder{
        TextView hoten,ngaysinh,gioitinh,sdt,quequan;
        ImageView avatar;
    }
}
