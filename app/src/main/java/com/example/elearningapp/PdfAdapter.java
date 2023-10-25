package com.example.elearningapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;


public class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.ViewHolder>{
    List<VideoModel> list;
    Context context;


    public ItemClickListner click;

    public void setClickListner(ItemClickListner mylistner){
        this.click=mylistner;
    }

    public PdfAdapter(List<VideoModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pdflayout,parent,false);
        return new PdfAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        VideoModel videoModel=list.get(position);
        holder.title.setText(videoModel.getTitle());
        holder.imageView.setImageResource(R.drawable.baseline_picture_as_pdf_24);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (click != null) {
                    click.onCLick(view,position);
                }
            }
        });
        holder.cardView.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_reccycle));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


  protected    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView title;

        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imgag);

            title=itemView.findViewById(R.id.pdfTitle);
            cardView=itemView.findViewById(R.id.pdfList);

        }

        @Override
        public void onClick(View v) {
            if(click !=null){
                click.onCLick(v,getAdapterPosition());
            }
        }
    }
}
