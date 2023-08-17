package com.example.andymaster.Android_Courses.Ae;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.andymaster.Android_Courses.Ad.File_Strucure;
import com.example.andymaster.Android_Courses.Ad.File_structure_mcqs;
import com.example.andymaster.R;

public class Broadcast_receiver extends AppCompatActivity {
private TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
        textView = findViewById(R.id.QUIZ_btn);
        textView.setOnClickListener(v -> startActivity(new Intent(Broadcast_receiver.this, Broadcast_receiver_mcqs.class)));
    }
}