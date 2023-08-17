package com.example.andymaster.Android_Courses.Ad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.andymaster.R;

public class File_Strucure extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_strucure);

        textView =findViewById(R.id.QUIZ_btn);
        textView.setOnClickListener(v -> startActivity(new Intent(File_Strucure.this ,File_structure_mcqs.class)));
    }
}