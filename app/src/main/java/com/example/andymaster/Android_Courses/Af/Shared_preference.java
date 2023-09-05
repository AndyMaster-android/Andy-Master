package com.example.andymaster.Android_Courses.Af;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.andymaster.Android_Courses.Ae.Broadcast_receiver;
import com.example.andymaster.Android_Courses.Ae.Broadcast_receiver_mcqs;
import com.example.andymaster.R;

public class Shared_preference extends AppCompatActivity {
    private TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        textView = findViewById(R.id.QUIZ_btn);
        textView.setOnClickListener(v -> startActivity(new Intent(Shared_preference.this, Shared_preference_mcqs.class)));

    }
}