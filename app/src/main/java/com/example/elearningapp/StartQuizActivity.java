package com.example.elearningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.Wave;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StartQuizActivity extends AppCompatActivity {

    public static ArrayList<DataModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        list = new ArrayList<>();
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
        Sprite doubleBounce = new Wave();
        progressBar.setIndeterminateDrawable(doubleBounce);
        Intent inet = getIntent();
        String name = inet.getStringExtra("Name");


        if (name.equals("Python")) {
            myRef.child("Python questions").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot data : snapshot.getChildren()) {

                        DataModel dataModel = data.getValue(DataModel.class);

                        Log.d("String", dataModel.getQuestion() + "--" + dataModel.getQuestion() + "--" + dataModel.getAnswer() + "--" + dataModel.getOptionb() + "--" + dataModel.getOptionc() + "--" + dataModel.getOptiond());
                        list.add(dataModel);


                        if (list.size() == 25) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    startActivity(new Intent(StartQuizActivity.this, QuizActivity.class));
                                    finish();
                                }
                            }, 2000);
                        }


                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        }


        if (name.equals("Java Programing")) {
            myRef.child("questions").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot data : snapshot.getChildren()) {

                        DataModel dataModel = data.getValue(DataModel.class);

                        Log.d("String", dataModel.getQuestion() + "--" + dataModel.getQuestion() + "--" + dataModel.getAnswer() + "--" + dataModel.getOptionb() + "--" + dataModel.getOptionc() + "--" + dataModel.getOptiond());
                        list.add(dataModel);


                        if (list.size() == 25) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    startActivity(new Intent(StartQuizActivity.this, QuizActivity.class));
                                    finish();
                                }
                            }, 2000);
                        }


                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        }
    }

}