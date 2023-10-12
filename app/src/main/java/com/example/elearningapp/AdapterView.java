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

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdapterView extends RecyclerView.Adapter<AdapterView.ViewHolder> {
    List<VideoModel> list;
    Context context;
    String videoId2;

    public ItemClickListner click;

    public void setClickListner(ItemClickListner mylistner){
        this.click=mylistner;
    }

    public AdapterView(List<VideoModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapterclass,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        VideoModel videoModel=list.get(position);
        holder.title.setText(videoModel.getTitle());
        String youtubeUrl=videoModel.getLink();
        String regex = "(?<=v=|\\/videos\\/|\\/embed\\/|\\/v\\/|\\/e\\/|watch\\?v=|\\/watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed\\/_?vi?\\/|\\/v\\/|%2Fv%2F)[^#\\&\\?\\n]*";
        Matcher matcher = Pattern.compile(regex).matcher(youtubeUrl);
        if (matcher.find()) {
            videoId2 = matcher.group();
        }
        Picasso.get().load("https://img.youtube.com/vi/"+videoId2+"/maxresdefault.jpg").into(holder.imageView);
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

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView title;

        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.thumbNail);
            title=itemView.findViewById(R.id.Title);
            cardView=itemView.findViewById(R.id.videolist);

        }

        @Override
        public void onClick(View v) {
            if(click !=null){
                click.onCLick(v,getAdapterPosition());
            }
        }
    }
}
