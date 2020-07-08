package com.example.khutroapp.ui.screens.activity_roommate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_contract.adapter.ContractAdapter;
import com.example.khutroapp.ui.screens.activity_contract.model.ContractModel;
import com.example.khutroapp.ui.screens.activity_roommate.model.RoommateModel;

import java.util.List;

public class RoommateAdapter extends BaseAdapter {
    private Context context;
    public List<RoommateModel> listData;
    private LayoutInflater layoutInflater;

        public RoommateAdapter(Context context, List<RoommateModel> listData) {
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
        RoommateAdapter.ViewHolder hoder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.item_roommate,null);
            hoder= new RoommateAdapter.ViewHolder();
            hoder.hoten=(TextView) convertView.findViewById(R.id.txt_tenkt);
            hoder.ngaysinh=(TextView)convertView.findViewById(R.id.txt_ngaysinh);
            hoder.gioitinh=(TextView)convertView.findViewById(R.id.txt_gioitinh);
            hoder.sdt=(TextView) convertView.findViewById(R.id.txt_sdt);
            hoder.quequan=(TextView) convertView.findViewById(R.id.txt_quequan);
            convertView.setTag(hoder);
        } else {
            hoder=(RoommateAdapter.ViewHolder)convertView.getTag();
        }
        RoommateModel roommateModel= this.listData.get(position);

        hoder.hoten.setText(roommateModel.getTenkt());
        hoder.ngaysinh.setText(roommateModel.getNgaysinh());
        hoder.gioitinh.setText(roommateModel.getGioitinh());
        hoder.sdt.setText(roommateModel.getSdt());
        hoder.quequan.setText(roommateModel.getQuequan());
        return convertView;
    }
    static class ViewHolder{
        TextView hoten,ngaysinh,gioitinh,sdt,quequan;
    }
}
