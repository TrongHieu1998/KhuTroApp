package com.example.khutroapp.ui.screenchutro.activity_detailroom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screenchutro.activity_detailroom.model.DetailKhachThueModel;
import java.util.List;

public class DetailKhachThueAdapter extends BaseAdapter {

    private Context context;
    public List<DetailKhachThueModel> listData;
    private LayoutInflater layoutInflater;

    public DetailKhachThueAdapter(Context context, List<DetailKhachThueModel> listData) {
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
        DetailKhachThueAdapter.ViewHolder hoder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.item_detail_khachthue,null);
            hoder= new  DetailKhachThueAdapter.ViewHolder();
            hoder.hoten=(TextView) convertView.findViewById(R.id.txt_tenkt_detail);
            hoder.ngaysinh=(TextView)convertView.findViewById(R.id.txt_ngaysinh_detail);
            hoder.gioitinh=(TextView)convertView.findViewById(R.id.txt_gioitinh_detail);
            hoder.sdt=(TextView) convertView.findViewById(R.id.txt_sdt_detail);
            hoder.quequan=(TextView) convertView.findViewById(R.id.txt_quequan_detail);
            convertView.setTag(hoder);
        } else {
            hoder=( DetailKhachThueAdapter.ViewHolder)convertView.getTag();
        }
        DetailKhachThueModel khachThueModel= this.listData.get(position);

        hoder.hoten.setText(khachThueModel.getTenkt());
        hoder.ngaysinh.setText(khachThueModel.getNgaysinh());
        hoder.gioitinh.setText(khachThueModel.getGioitinh());
        hoder.sdt.setText(khachThueModel.getSdt());
        hoder.quequan.setText(khachThueModel.getQuequan());
        return convertView;
    }
    static class ViewHolder{
        TextView hoten,ngaysinh,gioitinh,sdt,quequan;
    }
}
