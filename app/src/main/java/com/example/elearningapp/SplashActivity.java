package com.example.elearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.loadinganimation.LoadingAnimation;

public class SplashActivity extends AppCompatActivity {

    ImageView imageView;

    LoadingAnimation loadingAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        loadingAnim=findViewById(R.id.loadingAnim);
        loadingAnim.setProgressVector(getResources().getDrawable(R.drawable.kkkkk));
        loadingAnim.setTextViewVisibility(true);
        loadingAnim.setTextStyle(true);
        loadingAnim.setTextColor(R.color.background);
        loadingAnim.setTextSize(12F);
        loadingAnim.setTextMsg("Please Wait");
        loadingAnim.setEnlarge(5);
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