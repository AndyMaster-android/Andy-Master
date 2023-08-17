package com.example.andymaster.Android_Courses.Ac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.andymaster.R;

public class native_platform extends AppCompatActivity {
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_platform);
        textView = findViewById(R.id.Quiz_btn);
        textView.setOnClickListener(v -> startActivity(new Intent(native_platform.this , native_mcqs.class)));
    }
}