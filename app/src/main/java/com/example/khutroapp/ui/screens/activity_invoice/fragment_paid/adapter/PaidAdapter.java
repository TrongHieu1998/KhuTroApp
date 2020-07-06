package com.example.khutroapp.ui.screens.activity_invoice.fragment_paid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_invoice.fragment_paid.model.PaidModel;

import java.util.List;

public class PaidAdapter extends BaseAdapter {
    public List<PaidModel> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public PaidAdapter(Context context,List<PaidModel> listData) {
        this.context = context;
        this.listData = listData;
        this.layoutInflater = LayoutInflater.from(context);
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
        PaidAdapter.ViewHoder hoder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.item_paid,null);
            hoder= new PaidAdapter.ViewHoder();

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
            hoder=(PaidAdapter.ViewHoder)convertView.getTag();
        }

        PaidModel paidmodel= this.listData.get(position);

        hoder.maphong.setText(paidmodel.getMaphong());
        hoder.thangnam.setText(paidmodel.getThangnam());
        hoder.mahdn.setText(paidmodel.getMahdn());
        hoder.tiendien.setText(paidmodel.getTiendien());
        hoder.tiennuoc.setText(paidmodel.getTiendien());
        hoder.tienwifi.setText(paidmodel.getTienwifi());
        hoder.tienrac.setText(paidmodel.getTienrac());
        hoder.tienphong.setText(paidmodel.getTienphong());
        hoder.tongtien.setText(paidmodel.getTongtien());

        return convertView;
    }

    static class ViewHoder {
        TextView maphong,mahdn,thangnam,tiendien,tiennuoc,tienwifi,tienrac,tienphong,tongtien;
    }
}
