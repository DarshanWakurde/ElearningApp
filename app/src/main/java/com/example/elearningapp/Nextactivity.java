package com.example.elearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Nextactivity extends AppCompatActivity {

    ImageView Course_image;
    TextView name_Course;

    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextactivity);

        Course_image=findViewById(R.id.courseImage);
        name_Course=findViewById(R.id.nameCourse);


        Intent nextIntent=getIntent();
        name_Course.setText(nextIntent.getStringExtra("Name"));
        Course_image.setImageResource(nextIntent.getIntExtra("Resid",R.drawable.java));

        btn=findViewById(R.id.video);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Nextactivity.this,VideoList.class));
            }
        });





    }
}