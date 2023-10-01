package com.example.elearningapp;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

    Context ctx;
    String str[];

    int[] images;

    LayoutInflater ly;

    public GridAdapter(Context ctx, String[] str, int[] images) {
        this.ctx = ctx;
        this.str = str;
        this.images = images;
        ly=LayoutInflater.from(ctx);
    }


    @Override
    public int getCount() {
        return str.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=ly.inflate(R.layout.grid_courses,null);
        TextView nameCourse=view.findViewById(R.id.nameCourse);
        ImageView imgCOurse=view.findViewById(R.id.courseImage);

        nameCourse.setText(str[i]);
        imgCOurse.setImageResource(images[i]);


        return view;
    }
}
