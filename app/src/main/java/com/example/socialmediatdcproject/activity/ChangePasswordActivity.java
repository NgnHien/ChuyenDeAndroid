package com.example.socialmediatdcproject;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChangePasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.change_password_layout);

        ImageButton iconBack = findViewById(R.id.icon_back);
        iconBack.setOnClickListener(v -> {

        });
    }
}
