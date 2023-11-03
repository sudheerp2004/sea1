package com.example.sea1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText log,pass;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText mail = findViewById(R.id.mail); //SUGAntH - Text
        EditText pass = findViewById(R.id.password); //revAMP
        Button login = findViewById(R.id.login);

        FirebaseAuth authentication = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mail.getText().toString();
                String password = pass.getText().toString();
                authentication.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent i = new Intent(MainActivity.this, page1.class);
                            startActivity(i);
                        }
                        else{

                            Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        TextView sign = findViewById(R.id.sign);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this, signup.class);
                startActivity(i);
            }
        });





    }
}