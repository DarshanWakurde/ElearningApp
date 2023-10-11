package com.example.elearningapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class nextCustomadapter extends ArrayAdapter<nextitem_models> {

    private ArrayList<nextitem_models> lists;
    Context context;

    public nextCustomadapter(@NonNull Context context, ArrayList<nextitem_models> lists) {
        super(context, R.layout.activity_nextactivity, lists);
        this.lists = lists;
        this.context = context;
    }

    private static class MyViewholder {
        TextView title;
        ImageView videos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        nextitem_models title = getItem(position);

        MyViewholder myViewholder;
        final View result;
        if (convertView == null) {
            myViewholder = new MyViewholder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.nextitems, parent, false
            );

            myViewholder.title = (TextView) convertView.findViewById(R.id.title1);
            myViewholder.videos = (ImageView) convertView.findViewById(R.id.videos);

            result = convertView;

            convertView.setTag(myViewholder);
        } else {
            myViewholder = (MyViewholder) convertView.getTag();
            result = convertView;
        }
        myViewholder.title.setText(title.getTitle1());
        myViewholder.videos.setImageResource(title.getVideos());


        return result;
    }


}
