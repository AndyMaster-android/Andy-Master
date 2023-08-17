package com.example.andymaster.Android_Courses.Ae;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.andymaster.R;

public class services_compnant extends AppCompatActivity {
    private TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_compnant);
        textView = findViewById(R.id.QUIZ_btn);
        textView.setOnClickListener(v -> startActivity(new Intent(services_compnant.this, services_mcqs.class)));
    }
}