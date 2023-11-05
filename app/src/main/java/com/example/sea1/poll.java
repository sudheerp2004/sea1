package com.example.sea1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sea1.databinding.ActivityPollBinding;

public class poll extends AppCompatActivity {

    private ActivityPollBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("water", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        binding = ActivityPollBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.submitButton.setOnClickListener(view1 -> {
            int checkedId = binding.rgOptions.getCheckedRadioButtonId();

            if (checkedId != -1) {
                RadioButton selected = binding.rgOptions.findViewById(checkedId);
                String value = selected.getText().toString();

                int count = sharedPreferences.getInt(value, 0);
                editor.putInt(value, count+1);
                editor.apply();

                Log.d("RADIOBUTTON", "Option selected: " + value);

                Intent i = new Intent(poll.this, barchart.class);
                startActivity(i);
            } else {
                Toast.makeText(poll.this, "Choose an option", Toast.LENGTH_SHORT).show();
            }
        });

        binding.graphButton.setOnClickListener(view1 -> {
            Intent i = new Intent(poll.this, barchart.class);
            startActivity(i);
        });
    }
}