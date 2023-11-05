package com.example.sea1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class barchart extends AppCompatActivity {
    private BarChart barChart;
    private String[] cities = {"Selangor", "Kuala Lumpur", "George Town", "Ipoh", "Klang", "Alor Setar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barchart);

        barChart = findViewById(R.id.barchart);

        ArrayList<BarEntry> barEntries = bindValue();
        BarDataSet barDataSet = new BarDataSet(barEntries, "Water Request Analysis");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.9f);

        barChart.setData(barData);
        barChart.getDescription().setEnabled(false);
        barChart.setFitBars(true);

        // Customize X-axis
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(getXAxisValues()));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelCount(cities.length);
        xAxis.setLabelRotationAngle(45);
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);

        barChart.invalidate();
    }

    private ArrayList<BarEntry> bindValue() {

        SharedPreferences sharedPreferences = getSharedPreferences("water", Context.MODE_PRIVATE);

        ArrayList<BarEntry> barEntries = new ArrayList<>();

        for (int i = 0; i < cities.length; i++) {
            int value = sharedPreferences.getInt(cities[i], 0);
            barEntries.add(new BarEntry(i, value));
        }

        return barEntries;
    }

    private String[] getXAxisValues() {
        return new String[]{"Selangor", "Kuala Lumpur", "George Town", "Ipoh", "Klang", "Alor Setar"};
    }
}