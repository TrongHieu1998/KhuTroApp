package com.example.khutroapp.ui.screens.activity_tabernacle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_tabernacle.model.TabernacleModel;

import java.util.List;

public class TabernacleAdapter extends BaseAdapter {
    private Context context;
    public List<TabernacleModel> listData;
    private LayoutInflater layoutInflater;

    public TabernacleAdapter(Context context, List<TabernacleModel> listData) {
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
        TabernacleAdapter.ViewHolder hoder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.item_tabernacle,null);
            hoder= new TabernacleAdapter.ViewHolder();
            hoder.matt=(TextView) convertView.findViewById(R.id.txt_matt);
            hoder.tenkt=(TextView)convertView.findViewById(R.id.txt_tenkt);
            hoder.ngaylamgiay=(TextView)convertView.findViewById(R.id.txt_ngaylamgiay);
            hoder.ngayhethan=(TextView) convertView.findViewById(R.id.txt_ngayhethan);
            hoder.quanhechutro=(TextView) convertView.findViewById(R.id.txt_quanhechutro);
            convertView.setTag(hoder);
        } else {
            hoder=(TabernacleAdapter.ViewHolder)convertView.getTag();
        }
        TabernacleModel tabernacleModel= this.listData.get(position);

        hoder.matt.setText(tabernacleModel.getMatt());
        hoder.tenkt.setText(tabernacleModel.getTenkt());
        hoder.ngaylamgiay.setText(tabernacleModel.getNgatlamgiay());
        hoder.ngayhethan.setText(tabernacleModel.getNgayhethan());
        hoder.quanhechutro.setText(tabernacleModel.getQuanhechutro());
        return convertView;
    }
    static class ViewHolder{
        TextView matt,tenkt,ngaylamgiay,ngayhethan,quanhechutro;
    }
}
