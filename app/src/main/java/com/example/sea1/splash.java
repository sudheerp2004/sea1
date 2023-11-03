package com.example.sea1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class splash extends AppCompatActivity {

    public  static int sleeptimer=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Toast.makeText(this, "WELCOME", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i =new Intent(splash.this,MainActivity.class);
                startActivity(i);
            }
        },sleeptimer);
    }
}