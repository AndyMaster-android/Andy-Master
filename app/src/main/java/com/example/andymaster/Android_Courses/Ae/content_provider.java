package com.example.andymaster.Android_Courses.Ae;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.andymaster.Android_Courses.Ad.File_Strucure;
import com.example.andymaster.Android_Courses.Ad.File_structure_mcqs;
import com.example.andymaster.R;

public class content_provider extends AppCompatActivity {

    private TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        textView =findViewById(R.id.QUIZ_btn);
        textView.setOnClickListener(v -> startActivity(new Intent(content_provider.this , content_provider_mcqs.class)));

    }
    }
