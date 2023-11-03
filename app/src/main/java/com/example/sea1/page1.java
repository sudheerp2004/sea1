package com.example.sea1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class page1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        Button g1=findViewById(R.id.g1);
        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(page1.this, poll.class);
                startActivity(i);
            }
        });
        Button g2=findViewById(R.id.g2);
        g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(page1.this, poll1.class);
                startActivity(i);

            }
        });

    }
}