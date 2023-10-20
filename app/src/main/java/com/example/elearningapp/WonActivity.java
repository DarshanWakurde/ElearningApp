package com.example.elearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WonActivity extends AppCompatActivity {

    TextView correct,wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        Intent intent=getIntent();
        int  corr=intent.getIntExtra("Correct",0);
        int Wrong=intent.getIntExtra("Wrong",0);

        correct=findViewById(R.id.corrext);
        wrong=findViewById(R.id.wrong);

        correct.setText("Vlaue-"+corr);
        wrong.setText("Vlaue-"+Wrong);
    }
}