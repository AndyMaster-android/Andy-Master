package com.example.andymaster.Android_Courses.Ac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.andymaster.R;

public class Platform_Android extends AppCompatActivity {
    RelativeLayout Native, crosspatform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platform_android);
        Native = findViewById(R.id.Native_App);
        crosspatform = findViewById(R.id.cross_App);
        Native.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Platform_Android.this, native_platform.class));
            }
        });
        crosspatform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
startActivity(new Intent(Platform_Android.this , cross_App.class));
            }
        });
    }
}