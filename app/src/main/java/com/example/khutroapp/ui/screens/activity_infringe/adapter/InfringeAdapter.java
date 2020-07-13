package com.example.khutroapp.ui.screens.activity_infringe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_indexwater.adapter.IndexWaterAdapter;
import com.example.khutroapp.ui.screens.activity_indexwater.model.IndexWaterModel;
import com.example.khutroapp.ui.screens.activity_infringe.model.InfringeModel;

import java.util.List;

public class InfringeAdapter extends BaseAdapter {
    private Context context;
    public List<InfringeModel> listData;
    private LayoutInflater layoutInflater;

    public InfringeAdapter(Context context, List<InfringeModel> listData) {
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
        InfringeAdapter.ViewHoder holder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.item_infringe,null);
            holder= new InfringeAdapter.ViewHoder();
            holder.mavipham=(TextView) convertView.findViewById(R.id.txt_mavipham);
            holder.ngayvipham=(TextView)convertView.findViewById(R.id.txt_ngayvipham);
            holder.tenkt=(TextView)convertView.findViewById(R.id.txt_tenkt);
            holder.noidung=(TextView) convertView.findViewById(R.id.txt_noidung);
            holder.hinhphat=(TextView) convertView.findViewById(R.id.txt_hinhphat);
            holder.ghichu=(TextView)convertView.findViewById(R.id.txt_ghichu);
            convertView.setTag(holder);
        } else {
            holder=(InfringeAdapter.ViewHoder)convertView.getTag();
        }
        InfringeModel infringeModel= this.listData.get(position);

        holder.mavipham.setText(infringeModel.getMavipham());
        holder.ngayvipham.setText(infringeModel.getNgayvipham());
        holder.tenkt.setText(infringeModel.getTenkt());
        holder.noidung.setText(infringeModel.getNoidung());
        holder.hinhphat.setText(infringeModel.getHinhphat());
        holder.ghichu.setText(infringeModel.getGhichu());
        return convertView;
    }
    static class ViewHoder{
        TextView mavipham,ngayvipham,tenkt,noidung,hinhphat,ghichu;
    }
}
