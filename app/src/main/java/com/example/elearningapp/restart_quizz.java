package com.example.elearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class restart_quizz extends AppCompatActivity {
    Button start;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restart_quizz);

        start=findViewById(R.id.start);
        textView=findViewById(R.id.textView3);
        Intent intent=getIntent();
        String name= intent.getStringExtra("Name");
textView.setText(name);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(restart_quizz.this,StartQuizActivity.class);
                i.putExtra("Name",name);
                startActivity(i);
            }

        });
    }
}