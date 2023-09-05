package com.example.andymaster.Android_Tetorials.A_TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.andymaster.Android_Tetorials.A_btn.Button_Glossary;
import com.example.andymaster.Android_Tetorials.A_btn.Button_output;
import com.example.andymaster.Android_Tetorials.A_btn.Button_source_code;
import com.example.andymaster.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Text_View extends AppCompatActivity {
    TextView textView;

    FloatingActionButton fa_source_btn ,fa_Gloassary_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        textView = findViewById(R.id.TextView);
        fa_source_btn = findViewById(R.id.fa_source_Button);
        fa_Gloassary_btn = findViewById(R.id.fa_Glossary_Button);


        textView.setTextColor(getResources().getColor(R.color.monokia_pro_black));
        textView.setOnClickListener(v -> {

            textView.setTextColor(getResources().getColor(R.color.monokia_pro_sky));
            textView.setText("You Clicked the TextView");
        });
fa_source_btn.setOnClickListener(v -> { startActivity(new Intent(Text_View.this , TextView_source_code.class));});
fa_Gloassary_btn.setOnClickListener(v -> {startActivity(new Intent(Text_View.this , Gloassory_textView.class));});

    }
}