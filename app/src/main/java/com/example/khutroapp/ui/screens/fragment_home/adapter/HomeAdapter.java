package com.example.khutroapp.ui.screens.fragment_home.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.fragment_home.model.HomeModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private ArrayList<HomeModel> homeModelArrayList;
    private Context context;

    public HomeAdapter(ArrayList<HomeModel> homeModelArrayList, Context context) {
        this.homeModelArrayList = homeModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        HomeModel homeModel= homeModelArrayList.get(position);
        Picasso.get().load(homeModel.getImg()).into(holder.img);
        holder.title.setText(homeModel.getTitle());
    }

    @Override
    public int getItemCount() {
        return homeModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView img;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_itemhome);
            title=itemView.findViewById(R.id.txt_itemhome);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
//            Popular popular=popularArrayList.get(position);
//            Intent intent=new Intent(context, Detail_Popular_Activity.class);
//            intent.putExtra("image",popular.getImg());
//            intent.putExtra("title",popular.getTitle());
//            intent.putExtra("genre",popular.getGenres());
//            intent.putExtra("laster",popular.getLastest());
//            intent.putExtra("type",popular.getType());
//            intent.putExtra("detailUrl",popular.getDetailUrl());
 //           context.startActivity(intent);
        }
    }
}
