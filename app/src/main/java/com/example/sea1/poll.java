package com.example.sea1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.sea1.databinding.ActivityMainBinding;
import com.example.sea1.databinding.ActivityPollBinding;

public class poll extends AppCompatActivity {

    private ActivityPollBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        binding = ActivityPollBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}