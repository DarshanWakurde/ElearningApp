package com.example.elearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Nextactivity extends AppCompatActivity {

    ImageView Course_image;
    TextView name_Course;
    ListView listView;
    ArrayList<nextitem_models> items;

    nextCustomadapter nextCustomadapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextactivity);

        Course_image=findViewById(R.id.courseImage);
        name_Course=findViewById(R.id.nameCourse);
        listView=findViewById(R.id.listview1);

        Intent nextIntent=getIntent();
        String Name=nextIntent.getStringExtra("Name");
        name_Course.setText(nextIntent.getStringExtra("Name"));
        Course_image.setImageResource(nextIntent.getIntExtra("Resid",R.drawable.java));


        items=new ArrayList<>();
        nextitem_models title2=new nextitem_models(R.drawable.videoss,"Videos");
        nextitem_models title3=new nextitem_models(R.drawable.quizz,"Quizz");
        nextitem_models title4=new nextitem_models(R.drawable.notes,"Notes");
        nextitem_models title5=new nextitem_models(R.drawable.papersm,"Question Papers");

        items.add(title2);
        items.add(title3);
        items.add(title4);
        items.add(title5);

        nextCustomadapter=new nextCustomadapter(this,items);
        listView.setAdapter(nextCustomadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(items.get(i).getTitle1().equals("Videos")){
                    Intent intent=new Intent(Nextactivity.this,VideoList.class);
                    intent.putExtra("Name",Name);
                    startActivity(intent);
                }
            }
        });














    }
}