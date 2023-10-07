package com.example.elearningapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {


    String[] names;
    int [] pics;


    public ItemClickListner click;

    public void setClickListner(ItemClickListner mylistner){
        this.click=mylistner;

    }

    public MainAdapter(String[] names, int[] pics) {
        this.names = names;
        this.pics = pics;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_courses,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.imageView.setImageResource(pics[position]);
        holder.textView.setText(names[position]);
        
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (click != null) {
                    click.onCLick(view,position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.courseImage);
            textView=itemView.findViewById(R.id.nameCourse);
        }

        @Override
        public void onClick(View view) {
            if(click !=null){
                click.onCLick(view,getAdapterPosition());
            }
        }
    }
}
