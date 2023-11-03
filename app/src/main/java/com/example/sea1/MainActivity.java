package com.example.sea1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sea1.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        FirebaseAuth authentication = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            Intent i = new Intent(MainActivity.this, page1.class);
            startActivity(i);
        }

        binding.login.setOnClickListener( view1 -> {
            String email = binding.mail.getText().toString();
            String password = binding.password.getText().toString();

            if (email.equals("admin@sea.com") && password.equals("admin1234")) {
                Intent i = new Intent(MainActivity.this, poll.class);
                startActivity(i);
            }

            authentication.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Intent i = new Intent(MainActivity.this, page1.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                }
            });
        });

        binding.sign.setOnClickListener( view1 -> {
            Intent i= new Intent(MainActivity.this, signup.class);
            startActivity(i);
        });





    }
}