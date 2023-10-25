package com.example.elearningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class pdfset extends AppCompatActivity {

    CardView ournotes,mynotes;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfset);

        ournotes=findViewById(R.id.ournotes);
        mynotes=findViewById(R.id.mynotes);

        Intent inet=getIntent();


        ournotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(pdfset.this, Pdflist.class);
                intent.putExtra("Name",inet.getStringExtra("Name"));
                startActivity(intent);
            }
        });



    }







}