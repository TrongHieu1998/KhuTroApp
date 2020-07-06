package com.example.khutroapp.ui.screens.activity_indexwater.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_indexwater.model.IndexWaterModel;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_paid.adapter.PaidAdapter;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_paid.model.PaidModel;

import java.util.List;

public class IndexWaterAdapter extends BaseAdapter {
    public List<IndexWaterModel> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public IndexWaterAdapter(Context context,List<IndexWaterModel> listData) {
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
        IndexWaterAdapter.ViewHoder hoder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.item_indexwater,null);
            hoder= new IndexWaterAdapter.ViewHoder();
            hoder.thangnam=(TextView) convertView.findViewById(R.id.txt_thangnam);
            hoder.csddau=(TextView)convertView.findViewById(R.id.txt_csddau);
            hoder.csdcuoi=(TextView)convertView.findViewById(R.id.txt_csdcuoi);
            hoder.sodien=(TextView) convertView.findViewById(R.id.txt_sodien);
            hoder.csndau=(TextView) convertView.findViewById(R.id.txt_csndau);
            hoder.csncuoi=(TextView)convertView.findViewById(R.id.txt_csncuoi);
            hoder.sonuoc=(TextView)convertView.findViewById(R.id.txt_sonuoc);
            convertView.setTag(hoder);
        } else {
            hoder=(IndexWaterAdapter.ViewHoder)convertView.getTag();
        }
        IndexWaterModel indexWaterModel= this.listData.get(position);

        hoder.thangnam.setText(indexWaterModel.getThangnam());
        hoder.csddau.setText(indexWaterModel.getCsddau());
        hoder.csdcuoi.setText(indexWaterModel.getCsdcuoi());
        hoder.sodien.setText(indexWaterModel.getSodien());
        hoder.csndau.setText(indexWaterModel.getCsndau());
        hoder.csncuoi.setText(indexWaterModel.getCsncuoi());
        hoder.sonuoc.setText(indexWaterModel.getSonuoc());

        return convertView;
    }
    static class ViewHoder{
        TextView thangnam,csddau,csdcuoi,sodien,csndau,csncuoi,sonuoc;
    }
}
