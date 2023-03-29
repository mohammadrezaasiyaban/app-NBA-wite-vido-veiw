package com.example.nbaapk.recyaceler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nbaapk.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    Context context;
    ArrayList<News> newsArrayList;

    public MyAdapter(Context context,ArrayList<News> newsArrayList) {
        this.context=context;
        this.newsArrayList=newsArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.teams_row_lavout,parent,false);
        return new MyViewHolder(v);
    }




    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        News news= newsArrayList.get(position);
        holder.appCompatTextView.setText(news.heading);
        holder.appCompatImageView.setImageResource(news.titleImage);

    }
    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            appCompatTextView=itemView.findViewById(R.id.text_teams_view);
            appCompatImageView=itemView.findViewById(R.id.image_teams_view);
        }
    }
}
