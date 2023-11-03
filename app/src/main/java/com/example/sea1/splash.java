package com.example.sea1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class splash extends AppCompatActivity {

    public static int SPLASHTIME = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        Toast.makeText(this, "WELCOME", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(() -> {
            Intent i =new Intent(splash.this,MainActivity.class);
            startActivity(i);
        },SPLASHTIME);
    }
}