package com.example.andymaster.Android_Courses.Af;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.andymaster.R;

public class Storage extends AppCompatActivity {
private RelativeLayout App_Spacific_storage ,Database , Shared_preference , Shared_storage;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        App_Spacific_storage = findViewById(R.id.App_Spacific_storage);
        Database = findViewById(R.id.Database);
        Shared_storage = findViewById(R.id.Shared_storage);
        Shared_preference = findViewById(R.id.Shared_preference);


        App_Spacific_storage.setOnClickListener(v -> startActivity(new Intent(Storage.this , App_Specific_storage.class)));
        Database.setOnClickListener(v -> startActivity(new Intent(Storage.this , DataBase.class)));
        Shared_storage.setOnClickListener(v -> startActivity(new Intent(Storage.this , Shared_storage.class)));
        Shared_preference.setOnClickListener(v -> startActivity(new Intent(Storage.this , Shared_preference.class)));

    }
}