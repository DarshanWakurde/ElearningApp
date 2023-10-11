package com.example.elearningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VideoScreen extends AppCompatActivity {
    boolean check =true;
    String videoId2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_screen);

        imageView=findViewById(R.id.fullScreen);
        Intent intent=getIntent();
        String link=intent.getStringExtra("Link");
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        String youtubeUrl=link;
        String regex = "(?<=v=|\\/videos\\/|\\/embed\\/|\\/v\\/|\\/e\\/|watch\\?v=|\\/watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed\\/_?vi?\\/|\\/v\\/|%2Fv%2F)[^#\\&\\?\\n]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(youtubeUrl);

        if (matcher.find()) {
            videoId2= matcher.group();
        } else {
            Toast.makeText(this, "no url FOund", Toast.LENGTH_SHORT).show();
        }
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = videoId2;
                youTubePlayer.loadVideo(videoId, 0);
            }
        });


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              check=!check;
                if(!check){
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
            }
        });



    }
}