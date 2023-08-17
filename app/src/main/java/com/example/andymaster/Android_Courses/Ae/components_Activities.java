package com.example.andymaster.Android_Courses.Ae;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.andymaster.R;

public class components_Activities extends AppCompatActivity {
    private TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_components_activities);
        textView = findViewById(R.id.QUIZ_btn);
        textView.setOnClickListener(v -> startActivity(new Intent(components_Activities.this, components_acitivtes_mcqs.class)));
    }
}