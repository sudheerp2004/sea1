package com.example.sea1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sea1.databinding.ActivityBargraphBinding;

import java.util.ArrayList;

public class barchart extends AppCompatActivity {
    private barchart barchart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barchart);
        barchart= findViewById(R.id.barchart);
        ArrayList<BarEntry>barEntries= new ArrayList<BarEntry>();
        barEntries.add(new BarEntry(1,5));
        barEntries.add(new BarEntry(2,5));
        barEntries.add(new BarEntry(3,5));
        barEntries.add(new BarEntry(4,5));
        barEntries.add(new BarEntry(5,5));

        BarDataSet barDataSet = new BarDataSet(barEntries,"Bar DataSet");
        barDataSet.Setcolors(ColorTemplate.COLORFUL_)



    }
}