package com.example.elearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    ArrayList barArrayList;
    ImageView dsa,java,sql,python,os,logout;

    TextView name,email,mobile;

    CircleImageView imageView;

    List<QuizModel> list;
    DatabaseHelper db;
    Cursor cur;

    DatabaseHelperPython databaseHelperPython;
    DataBaseHelperJava dataBaseHelperJava;
    DatabaseHelperOs databaseHelperOs;
    DataBaseHelperSql dataBaseHelperSql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        db=new DatabaseHelper(this);
        databaseHelperPython=new DatabaseHelperPython(this);
        dataBaseHelperJava=new DataBaseHelperJava(this);
        databaseHelperOs=new DatabaseHelperOs(this);
        dataBaseHelperSql=new DataBaseHelperSql(this);




        Dialog dialog=new Dialog(ProfileActivity.this);
        dialog.setContentView(R.layout.datagrphpopup);

        name=findViewById(R.id.Profname);
        email=findViewById(R.id.Profemail);
        mobile=findViewById(R.id.ProfMobile);

        imageView=findViewById(R.id.profimg);


        Intent inet=getIntent();
        Toast.makeText(this, inet.getStringExtra("Name"), Toast.LENGTH_SHORT).show();



        name.setText(inet.getStringExtra("Name"));
        email.setText(inet.getStringExtra("Email"));
        mobile.setText(String.valueOf(inet.getLongExtra("Mobile",0)));
        imageView.setImageResource(inet.getIntExtra("Imagee",R.drawable.harry));

        logout=findViewById(R.id.logout);

        BarChart barChart=dialog.findViewById(R.id.barchar);


        dsa=findViewById(R.id.grfdsa);
        os=findViewById(R.id.grfos);
        sql=findViewById(R.id.grfsql); java=findViewById(R.id.grfjava);
        python=findViewById(R.id.grfpython);

        dsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cur=db.getAll();
                getData();
                BarDataSet barDataSet=new BarDataSet(barArrayList,"");
                barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                barDataSet.setValueTextSize(16f);
                BarData barData=new BarData(barDataSet);
                barChart.setData(barData);

                dialog.show();
                dialog.setCanceledOnTouchOutside(true);

            }
        });

        sql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cur=dataBaseHelperSql.getAll();
                getData();
                BarDataSet barDataSet=new BarDataSet(barArrayList,"");
                barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                barDataSet.setValueTextSize(16f);
                BarData barData=new BarData(barDataSet);
                barChart.setData(barData);

                dialog.show();
                dialog.setCanceledOnTouchOutside(true);

            }
        });
        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cur=dataBaseHelperJava.getAll();
                getData();
                BarDataSet barDataSet=new BarDataSet(barArrayList,"");
                barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                barDataSet.setValueTextSize(16f);
                BarData barData=new BarData(barDataSet);
                barChart.setData(barData);

                dialog.show();
                dialog.setCanceledOnTouchOutside(true);

            }
        });
        python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cur=databaseHelperPython.getAll();
                getData();
                BarDataSet barDataSet=new BarDataSet(barArrayList,"");
                barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                barDataSet.setValueTextSize(16f);
                BarData barData=new BarData(barDataSet);
                barChart.setData(barData);

                dialog.show();
                dialog.setCanceledOnTouchOutside(true);

            }
        });
        os.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cur=databaseHelperOs.getAll();
                getData();
                BarDataSet barDataSet=new BarDataSet(barArrayList,"");
                barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                barDataSet.setValueTextSize(16f);
                BarData barData=new BarData(barDataSet);
                barChart.setData(barData);

                dialog.show();
                dialog.setCanceledOnTouchOutside(true);

            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ProfileActivity.this,MainActivity.class));
            }
        });







    }

    private void getData() {
        barArrayList=new ArrayList();
        float i= 2.0F;
        if(cur.getCount()>0){
            while (cur.moveToNext()){
                barArrayList.add(new BarEntry(i,Integer.parseInt(cur.getString(1))));
                Log.d("Data",cur.getString(1));
                i++;
                if(i==7){
                    break;
                }
            }
        }else {
            Toast.makeText(this, "data nahi hai bhai", Toast.LENGTH_SHORT).show();
        }



    }
}