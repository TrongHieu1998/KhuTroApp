package com.example.khutroapp.ui.screens.activity_invoice.fragment_unpaid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_unpaid.model.UnpaidModel;

import java.util.List;

public class UnpaidAdapter extends BaseAdapter {

    private Context context;
    public List<UnpaidModel> listData;
    private LayoutInflater layoutInflater;


    public UnpaidAdapter(Context context,List<UnpaidModel> listData) {
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
       UnpaidAdapter.ViewHoder hoder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.item_unpaid,null);
            hoder= new  UnpaidAdapter.ViewHoder();

            hoder.maphong=(TextView)convertView.findViewById(R.id.txt_maphong);
            hoder.thangnam=(TextView)convertView.findViewById(R.id.txt_thangnam);
            hoder.mahdn=(TextView) convertView.findViewById(R.id.txt_mahdon);
            hoder.tiendien=(TextView) convertView.findViewById(R.id.txt_tiendien);
            hoder.tiennuoc=(TextView)convertView.findViewById(R.id.txt_tiennuoc);
            hoder.tienwifi=(TextView)convertView.findViewById(R.id.txt_tienwifi);
            hoder.tienrac=(TextView)convertView.findViewById(R.id.txt_tienrac);
            hoder.tienphong=(TextView)convertView.findViewById(R.id.txt_tienphong);
            hoder.tongtien=(TextView)convertView.findViewById(R.id.txt_tongtien);
            convertView.setTag(hoder);
        } else {
            hoder=( UnpaidAdapter.ViewHoder)convertView.getTag();
        }

        UnpaidModel unpaidModel= this.listData.get(position);

        hoder.maphong.setText(unpaidModel.getMaphong());
        hoder.thangnam.setText(unpaidModel.getThangnam());
        hoder.mahdn.setText(unpaidModel.getMahdn());
        hoder.tiendien.setText(unpaidModel.getTiendien());
        hoder.tiennuoc.setText(unpaidModel.getTiendien());
        hoder.tienwifi.setText(unpaidModel.getTienwifi());
        hoder.tienrac.setText(unpaidModel.getTienrac());
        hoder.tienphong.setText(unpaidModel.getTienphong());
        hoder.tongtien.setText(unpaidModel.getTongtien());

        return convertView;
    }

    static class ViewHoder {
        TextView maphong,mahdn,thangnam,tiendien,tiennuoc,tienwifi,tienrac,tienphong,tongtien;
    }
}
