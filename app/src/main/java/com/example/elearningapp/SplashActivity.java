package com.example.elearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        imageView=findViewById(R.id.imgview);

        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);

// Apply the animation to the ImageView
        imageView.startAnimation(fadeInAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
startActivity(new Intent(SplashActivity.this,MainActivity.class));
finish();
            }
        },3000);

    }
}