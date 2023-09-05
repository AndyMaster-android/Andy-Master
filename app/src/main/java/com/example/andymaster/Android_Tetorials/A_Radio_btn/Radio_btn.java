package com.example.andymaster.Android_Tetorials.A_Radio_btn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.andymaster.Android_Tetorials.A_btn.Button_Glossary;
import com.example.andymaster.Android_Tetorials.A_btn.Button_output;
import com.example.andymaster.Android_Tetorials.A_btn.Button_source_code;
import com.example.andymaster.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Radio_btn extends AppCompatActivity {
    RadioButton massi , renaldo;
    FloatingActionButton fa_source_btn ,fa_Gloassary_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_btn);

        fa_source_btn = findViewById(R.id.fa_source_Button);
        fa_Gloassary_btn = findViewById(R.id.fa_Glossary_Button);
        massi =findViewById(R.id.lionel_messi);
        renaldo =findViewById(R.id.Cristiano_Ronaldo);
        massi.setOnClickListener(v -> Toast.makeText(Radio_btn.this, ""+massi.getText().toString(), Toast.LENGTH_SHORT).show());
       renaldo.setOnClickListener(v -> {Toast.makeText(this, ""+renaldo.getText().toString(), Toast.LENGTH_SHORT).show();});

        fa_source_btn.setOnClickListener(v -> startActivity(new Intent(Radio_btn.this, Radio_btn_source_code.class)));
        fa_Gloassary_btn.setOnClickListener(v -> {startActivity(new Intent(Radio_btn.this , Radio_btn_Glossary.class));});

    }
}