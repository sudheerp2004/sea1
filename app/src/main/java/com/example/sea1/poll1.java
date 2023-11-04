package com.example.sea1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sea1.databinding.ActivityPoll1Binding;

public class poll1 extends AppCompatActivity {

    private ActivityPoll1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        binding = ActivityPoll1Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.submit.setOnClickListener(view1 -> {
            Intent i = new Intent(poll1.this, barchart.class);
            startActivity(i);
        });


    }
}