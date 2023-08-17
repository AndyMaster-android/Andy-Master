package com.example.andymaster.Android_Courses.Ad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.andymaster.R;

public class Overview_android_studio extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview_android_studio);
textView =findViewById(R.id.QUIZ_btn);
textView.setOnClickListener(v -> startActivity(new Intent(Overview_android_studio.this ,Overview_mcqs.class)));
    }
    }
