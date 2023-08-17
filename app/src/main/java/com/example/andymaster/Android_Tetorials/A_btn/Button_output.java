package com.example.andymaster.Android_Tetorials.A_btn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;

import com.example.andymaster.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Button_output extends AppCompatActivity {

    AppCompatButton btn;
    FloatingActionButton fa_source_btn ,fa_Gloassary_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_output);
        btn = findViewById(R.id.btn);
        fa_source_btn = findViewById(R.id.fa_source_Button);
        fa_Gloassary_btn = findViewById(R.id.fa_Glossary_Button);

        btn.setOnClickListener(v -> {
            btn.setBackgroundResource(R.drawable.group_3);
            Snackbar snackbar = Snackbar.make(findViewById(R.id.Layout), "Yes! Button Pressed! ", Snackbar.LENGTH_LONG)
                    .setAction("OK", v1 -> btn.setBackgroundResource(R.drawable.next_btn));
            snackbar.show();
        });

        fa_source_btn.setOnClickListener(v -> startActivity(new Intent(Button_output.this, Button_source_code.class)));
        fa_Gloassary_btn.setOnClickListener(v -> {startActivity(new Intent(Button_output.this ,Button_Glossary.class));});
    }
}