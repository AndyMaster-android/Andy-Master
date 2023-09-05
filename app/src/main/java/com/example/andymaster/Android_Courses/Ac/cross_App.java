package com.example.andymaster.Android_Courses.Ac;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.andymaster.R;

public class cross_App extends AppCompatActivity {

    TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_app);

        textView = findViewById(R.id.QUIZ_btn);
        textView.setOnClickListener(v -> {
            startActivity(new Intent(cross_App.this , cross_app_quiz.class));
        });

    }
}