package com.example.elearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class WonActivity extends AppCompatActivity {

    TextView correct,wrong;

    PieChart pieChart;
    public int  corr;
    public int Wrong;
    public  int NotAttept;
    List<PieEntry> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        pieChart=findViewById(R.id.char11);

        Intent intent=getIntent();
        corr=intent.getIntExtra("Correct",0);
        Wrong=intent.getIntExtra("Wrong",0);
        NotAttept=intent.getIntExtra("NotAttemt",0);
        correct=findViewById(R.id.corrext);
        wrong=findViewById(R.id.wrong);
        list=new ArrayList<>();
        correct.setText(" "+corr);
        wrong.setText(" "+Wrong);

        setValue();
        setUpChart();
    }
    private void setUpChart() {
        PieDataSet pieDataSet=new PieDataSet(list,"Quiz Data");
        PieData pieData=new PieData(pieDataSet);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(getResources().getColor(R.color.white));
        pieData.setValueTextSize(12f);
        pieChart.setData(pieData);
        pieChart.invalidate();

    }

    private void setValue() {
        list.add(new PieEntry(corr,"Correct"));
        list.add(new PieEntry(Wrong,"Worng"));
        list.add(new PieEntry(NotAttept,"NotAttempt"));
    }
}