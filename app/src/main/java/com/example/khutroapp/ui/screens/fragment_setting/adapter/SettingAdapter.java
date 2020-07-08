package com.example.khutroapp.ui.screens.fragment_setting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_roommate.adapter.RoommateAdapter;
import com.example.khutroapp.ui.screens.activity_roommate.model.RoommateModel;
import com.example.khutroapp.ui.screens.fragment_setting.model.SettingModel;

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
            convertView=layoutInflater.inflate(R.layout.item_setting,null);
            hoder= new SettingAdapter.ViewHolder();
            hoder.hoten=(TextView) convertView.findViewById(R.id.txt_name);
            hoder.ngaysinh=(TextView)convertView.findViewById(R.id.txt_birthday);
            hoder.gioitinh=(TextView)convertView.findViewById(R.id.txt_gender);
            hoder.sdt=(TextView) convertView.findViewById(R.id.txt_phonenumber);
            hoder.quequan=(TextView) convertView.findViewById(R.id.txt_hometow);
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
        return convertView;
    }
    static class ViewHolder{
        TextView hoten,ngaysinh,gioitinh,sdt,quequan;
    }
}
