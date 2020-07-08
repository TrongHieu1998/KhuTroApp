package com.example.khutroapp.ui.screens.activity_contract.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_contract.model.ContractModel;

import java.util.List;

public class ContractAdapter extends BaseAdapter {
    private Context context;
    public List<ContractModel> listData;
    private LayoutInflater layoutInflater;

    public ContractAdapter(Context context,List<ContractModel> listData) {
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
        ContractAdapter.ViewHolder hoder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.item_contract,null);
            hoder= new ContractAdapter.ViewHolder();
            hoder.txt_mahd=(TextView) convertView.findViewById(R.id.txt_mahd);
            hoder.txt_tennguoiki=(TextView)convertView.findViewById(R.id.txt_tennguoiki);
            hoder.txt_tentang=(TextView)convertView.findViewById(R.id.txt_tentang);
            hoder.txt_tenphong=(TextView) convertView.findViewById(R.id.txt_tenphong);
            hoder.txt_loaiphong=(TextView) convertView.findViewById(R.id.txt_loaiphong);
            hoder.txt_ngaylap=(TextView) convertView.findViewById(R.id.txt_ngaylap);
            hoder.txt_ngayhethan=(TextView)convertView.findViewById(R.id.txt_ngaytra);
            hoder.txt_tiencoc=(TextView)convertView.findViewById(R.id.txt_tiencoc);
            hoder.txt_tinhtrang=(TextView) convertView.findViewById(R.id.txt_tinhtrang);
            convertView.setTag(hoder);
        } else {
            hoder=(ContractAdapter.ViewHolder)convertView.getTag();
        }
        ContractModel contractModel= this.listData.get(position);

        hoder.txt_mahd.setText(contractModel.getMahd());
        hoder.txt_tennguoiki.setText(contractModel.getTennguoiki());
        hoder.txt_tentang.setText(contractModel.getTentang());
        hoder.txt_tenphong.setText(contractModel.getTenphong());
        hoder.txt_loaiphong.setText(contractModel.getLoaiphong());
        hoder.txt_ngaylap.setText(contractModel.getNgaylap());
        hoder.txt_ngayhethan.setText(contractModel.getNgayhethan());
        hoder.txt_tiencoc.setText(contractModel.getTiencoc());
        hoder.txt_tinhtrang.setText(contractModel.getTinhtrang());
        return convertView;
    }
    static class ViewHolder {
        TextView txt_mahd,txt_tennguoiki,txt_tentang,txt_tenphong,txt_loaiphong,txt_ngaylap,txt_ngayhethan,txt_tiencoc,txt_tinhtrang;
    }
}
