package com.example.sea1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sea1.databinding.ActivityPage1Binding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class page1 extends AppCompatActivity {

    private ActivityPage1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        FirebaseAuth authentication = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        binding = ActivityPage1Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.g1.setOnClickListener(view1 -> {
            Intent i = new Intent(page1.this, poll.class);
            startActivity(i);
        });



        binding.g2.setOnClickListener(view1 -> {
            Intent i = new Intent(page1.this, animate.class);
            startActivity(i);
        });
        binding.g4.setOnClickListener(view1 -> {
            Intent i = new Intent(page1.this, industry.class);
            startActivity(i);
        });
        binding.g3.setOnClickListener(view1 -> {
            Intent i = new Intent(page1.this, agri.class);
            startActivity(i);
        });

        binding.logout.setOnClickListener(view1 -> {
            authentication.signOut();
            Intent intent = new Intent(page1.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}