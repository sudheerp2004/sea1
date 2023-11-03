package com.example.sea1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sea1.databinding.ActivityMainBinding;
import com.example.sea1.databinding.ActivityPage1Binding;

public class page1 extends AppCompatActivity {

    private ActivityPage1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        binding = ActivityPage1Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.g1.setOnClickListener(view1 -> {
            Intent i = new Intent(page1.this, poll.class);
            startActivity(i);
        });


        binding.g2.setOnClickListener(view1 -> {
            Intent i = new Intent(page1.this, poll1.class);
            startActivity(i);
        });

    }
}