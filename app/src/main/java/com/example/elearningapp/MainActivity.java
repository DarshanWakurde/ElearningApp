package com.example.elearningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm=getSupportFragmentManager();

        //new thing
        FragmentTransaction fragtrran=fm.beginTransaction().add(R.id.myFrame,RegisterFragment.class,null);
        fragtrran.commit();

    }
}