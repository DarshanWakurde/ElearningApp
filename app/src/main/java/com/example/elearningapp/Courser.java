package com.example.elearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.GridView;

public class Courser extends AppCompatActivity {


    GridView gridLayout;

    String [] str={"Data Structure and algo","Java Programing","Operating System","Sql","Python"};
    int[] img={R.drawable.datastucture,R.drawable.java,R.drawable.ps,R.drawable.sql,R.drawable.python};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courser);

        gridLayout=findViewById(R.id.myCourses);



        GridAdapter adpt=new GridAdapter(this,str,img);
        gridLayout.setAdapter(adpt);


    }
}