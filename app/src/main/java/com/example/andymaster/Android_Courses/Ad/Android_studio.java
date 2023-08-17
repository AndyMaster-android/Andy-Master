package com.example.andymaster.Android_Courses.Ad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.andymaster.Android_Courses.Ac.cross_App;
import com.example.andymaster.R;

public class Android_studio extends AppCompatActivity {
    private RelativeLayout overview, filestructure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_studio);
        overview = findViewById(R.id.Native_App);
        filestructure = findViewById(R.id.cross_App);
        overview.setOnClickListener(v -> startActivity(new Intent(Android_studio.this, Overview_android_studio.class)));
        filestructure.setOnClickListener(v -> startActivity(new Intent(Android_studio.this , File_Strucure.class)));


    }
}