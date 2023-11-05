package com.example.sea1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.sea1.databinding.ActivityIndustryBinding;
import com.example.sea1.databinding.ActivityPage1Binding;

public class industry extends AppCompatActivity {

    private ActivityIndustryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        binding = ActivityIndustryBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.bufori.setOnClickListener(view1 -> {
            Intent i = new Intent(industry.this, in1.class);
            startActivity(i);
        });
        binding.ford.setOnClickListener(view1 -> {
            Intent i = new Intent(industry.this, in2.class);
            startActivity(i);
        });
        binding.HICOM.setOnClickListener(view1 -> {
            Intent i = new Intent(industry.this, in3.class);
            startActivity(i);
        });



    }
}
