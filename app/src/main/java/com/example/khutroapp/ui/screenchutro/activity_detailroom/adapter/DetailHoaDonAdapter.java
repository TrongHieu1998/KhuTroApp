package com.example.khutroapp.ui.screenchutro.activity_detailroom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screenchutro.activity_detailroom.model.DetailHoaDonModel;

import java.util.List;

public class DetailHoaDonAdapter extends BaseAdapter {

    private Context context;
    public List<DetailHoaDonModel> listData;
    private LayoutInflater layoutInflater;

    public DetailHoaDonAdapter(Context context, List<DetailHoaDonModel> listData) {
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
        DetailHoaDonAdapter.ViewHoder hoder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.item_detail_hoadon,null);
            hoder= new  DetailHoaDonAdapter.ViewHoder();

            hoder.maphong=(TextView)convertView.findViewById(R.id.txt_maphong_detail);
            hoder.thangnam=(TextView)convertView.findViewById(R.id.txt_thangnam_detail);
            hoder.mahdn=(TextView) convertView.findViewById(R.id.txt_mahdon_detail);
            hoder.tiendien=(TextView) convertView.findViewById(R.id.txt_tiendien_detail);
            hoder.tiennuoc=(TextView)convertView.findViewById(R.id.txt_tiennuoc_detail);
            hoder.tienwifi=(TextView)convertView.findViewById(R.id.txt_tienwifi_detail);
            hoder.tienrac=(TextView)convertView.findViewById(R.id.txt_tienrac_detail);
            hoder.tienphong=(TextView)convertView.findViewById(R.id.txt_tienphong_detail);
            hoder.tongtien=(TextView)convertView.findViewById(R.id.txt_tongtien_detail);
            convertView.setTag(hoder);
        } else {
            hoder=( DetailHoaDonAdapter.ViewHoder)convertView.getTag();
        }

        DetailHoaDonModel detailHoaDonModel= this.listData.get(position);

        hoder.maphong.setText(detailHoaDonModel.getMaphong());
        hoder.thangnam.setText(detailHoaDonModel.getThangnam());
        hoder.mahdn.setText(detailHoaDonModel.getMahdn());
        hoder.tiendien.setText(detailHoaDonModel.getTiendien());
        hoder.tiennuoc.setText(detailHoaDonModel.getTiennuoc());
        hoder.tienwifi.setText(detailHoaDonModel.getTienwifi());
        hoder.tienrac.setText(detailHoaDonModel.getTienrac());
        hoder.tienphong.setText(detailHoaDonModel.getTienphong());
        hoder.tongtien.setText(detailHoaDonModel.getTongtien());

        return convertView;
    }

    static class ViewHoder {
        TextView maphong,mahdn,thangnam,tiendien,tiennuoc,tienwifi,tienrac,tienphong,tongtien;
    }
}
