package com.example.khutroapp.ui.screens.fragment_setting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.fragment_setting.model.SettingModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SettingAdapet1 extends RecyclerView.Adapter<SettingAdapet1.ViewHolder> {

    List<SettingModel> settingModelArrayList;
    Context context;

    public SettingAdapet1(List<SettingModel> settingModelArrayList, Context context) {
        this.settingModelArrayList = settingModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting,parent,false);
        return new SettingAdapet1.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SettingModel settingModel=settingModelArrayList.get(position);

        holder.hoten.setText(settingModel.getTenkt());
        holder.ngaysinh.setText(settingModel.getNgaysinh());
        holder.gioitinh.setText(settingModel.getGioitinh());
        holder.sdt.setText(settingModel.getSdt());
        holder.quequan.setText(settingModel.getQuequan());
        Picasso.get().load(settingModel.getAvatar()).into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return settingModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView avatar;
        TextView hoten,ngaysinh,gioitinh,sdt,quequan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hoten=(TextView) itemView.findViewById(R.id.txt_name);
            ngaysinh=(TextView)itemView.findViewById(R.id.txt_birthday);
            gioitinh=(TextView)itemView.findViewById(R.id.txt_gender);
            sdt=(TextView) itemView.findViewById(R.id.txt_phonenumber);
            quequan=(TextView) itemView.findViewById(R.id.txt_hometow);
            avatar=(ImageView) itemView.findViewById(R.id.img_avatar);
        }
    }
}
