package com.example.khutroapp.ui.screenchutro.fragment_room_ct.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screenchutro.activity_detailroom.ActivityDetailRoom;
import com.example.khutroapp.ui.screenchutro.fragment_room_ct.model.RoomModel;
import com.example.khutroapp.ui.screens.MainActivity;

import java.util.List;

public class RoomAdapter extends BaseAdapter {
    private Context context;
    public List<RoomModel> listData;
    private LayoutInflater layoutInflater;

    public RoomAdapter(Context context, List<RoomModel> listData) {
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
        final RoomAdapter.ViewHolder holder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.item_room_ct,null);
            holder= new RoomAdapter.ViewHolder();
            holder.txt_tenphong=(TextView) convertView.findViewById(R.id.txt_tenphong);
            holder.cardView=convertView.findViewById(R.id.cardviewRoom);
            convertView.setTag(holder);
        } else {
            holder=(RoomAdapter.ViewHolder)convertView.getTag();
        }
        final RoomModel roomModel= this.listData.get(position);

        holder.txt_tenphong.setText(roomModel.getTenphong());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ActivityDetailRoom.class);
                intent.putExtra("TenPhong",roomModel.getTenphong());
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
