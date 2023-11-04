package com.example.sea1;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sea1.databinding.ActivityAgriBinding;

public class agri extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri selectedImageUri;
    private ActivityAgriBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAgriBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.selectImageButton.setOnClickListener(view1 -> selectImage());
    }

    public void selectImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                selectedImageUri = data.getData();
                binding.ivImage.setVisibility(View.VISIBLE);
                binding.ivImage.setImageURI(selectedImageUri);
            }
        }
    }
}