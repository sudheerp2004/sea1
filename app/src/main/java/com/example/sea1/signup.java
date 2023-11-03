package com.example.sea1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sea1.databinding.ActivityMainBinding;
import com.example.sea1.databinding.SignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {

    private SignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        binding = SignupBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        FirebaseAuth authentication = FirebaseAuth.getInstance();

        binding.signupButton.setOnClickListener(view1 -> {
            String email = binding.email.getText().toString();
            String password = binding.password.getText().toString();

            authentication.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            Log.d("FIREBASE", "createUserWithEmail:success");
                            FirebaseUser user = authentication.getCurrentUser();
                            Toast.makeText(signup.this, "New account created, Kindly login", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(signup.this, MainActivity.class);
                            startActivity(i);
                        } else {
                            Log.w("FIREBASE", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(signup.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}