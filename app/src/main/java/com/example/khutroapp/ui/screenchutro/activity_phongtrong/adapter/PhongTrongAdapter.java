package com.example.khutroapp.ui.screenchutro.activity_phongtrong.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screenchutro.activity_phongtrong.model.PhongTrongModel;
import com.example.khutroapp.ui.screenchutro.activity_taohopdong.ActivityTaohopdong;

import java.util.List;

public class PhongTrongAdapter extends BaseAdapter  {
    private Context context;
    public List<PhongTrongModel> listData;
    private LayoutInflater layoutInflater;

    public PhongTrongAdapter(Context context, List<PhongTrongModel> listData) {
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
        final PhongTrongAdapter.ViewHolder holder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.item_phongtrong,null);
            holder= new PhongTrongAdapter.ViewHolder();
            holder.txt_tenphong=(TextView) convertView.findViewById(R.id.txt_tenphong);
            holder.cardView=convertView.findViewById(R.id.cardviewphongtrong);
            convertView.setTag(holder);
        } else {
            holder=(PhongTrongAdapter.ViewHolder)convertView.getTag();
        }
        final PhongTrongModel phongTrongModel= this.listData.get(position);

        holder.txt_tenphong.setText(phongTrongModel.getTenphong());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityTaohopdong.class);
                intent.putExtra("TenPhong",phongTrongModel.getTenphong());
                context.startActivity(intent);
            }
        });
        return convertView;
    }
    static class ViewHolder {
        TextView txt_tenphong;
        CardView cardView;
    }
}
