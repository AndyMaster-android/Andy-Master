package com.example.andymaster.Android_Courses.Ae;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.andymaster.R;

public class Component extends AppCompatActivity {
    RelativeLayout Activities, Services, Content_provider, Broadcast_reciver;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component);
        Activities = findViewById(R.id.Activities);
        Services = findViewById(R.id.Services);
        Content_provider = findViewById(R.id.content_provider);
        Broadcast_reciver = findViewById(R.id.Broadcast_receiver);
        Activities.setOnClickListener(v -> {
            startActivity(new Intent(Component.this, components_Activities.class));
        });
        Services.setOnClickListener(v -> {
            startActivity(new Intent(Component.this, services_compnant.class));
        });
        Content_provider.setOnClickListener(v -> {
            startActivity(new Intent(Component.this, Broadcast_receiver.class));
        });
        Broadcast_reciver.setOnClickListener(v -> startActivity(new Intent(Component.this , Broadcast_receiver.class)));

    }
}