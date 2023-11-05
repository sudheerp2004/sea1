package com.example.sea1;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sea1.databinding.ActivityBarchartBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class barchart extends AppCompatActivity {
    private ActivityBarchartBinding binding;
    private BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barchart);

        binding = ActivityBarchartBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        barChart = binding.barchart;

        ArrayList<BarEntry>barEntries= new ArrayList<BarEntry>();
        barEntries.add(new BarEntry(6,2));
        barEntries.add(new BarEntry(2,9));
        barEntries.add(new BarEntry(8,4));
        barEntries.add(new BarEntry(4,7));


        BarDataSet barDataSet = new BarDataSet(barEntries,"Bar DataSet");
        barDataSet.setColor(getResources().getColor(R.color.colorPrimary)); // Set color

        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.9f); // Set the width of bars

        barChart.setData(barData);
        barChart.getDescription().setEnabled(false);
        barChart.setFitBars(true);
        barChart.invalidate();
    }
}