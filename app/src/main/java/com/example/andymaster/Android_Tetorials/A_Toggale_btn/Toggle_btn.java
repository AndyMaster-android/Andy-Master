package com.example.andymaster.Android_Tetorials.A_Toggale_btn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.andymaster.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Toggle_btn extends AppCompatActivity {

    ToggleButton toggleButton;
    FloatingActionButton fa_source_btn ,fa_Gloassary_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_btn);
        toggleButton = findViewById(R.id.simpleToggleButton1);

        fa_source_btn = findViewById(R.id.fa_source_Button);
        fa_Gloassary_btn = findViewById(R.id.fa_Glossary_Button);
        fa_source_btn.setOnClickListener(v -> { startActivity(new Intent(Toggle_btn.this , Toggale_Btn_source_code.class));});
        fa_Gloassary_btn.setOnClickListener(v -> {startActivity(new Intent(Toggle_btn.this , Toggale_btn_Glossary.class));});

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleButton.setText("ON");
                Toast.makeText(Toggle_btn.this, ""+ toggleButton.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}