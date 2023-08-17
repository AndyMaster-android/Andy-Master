package com.example.andymaster.Android_Tetorials.A_SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.andymaster.Android_Tetorials.A_Radio_btn.Radio_btn_Glossary;
import com.example.andymaster.Android_Tetorials.A_RatingBar.RatingBar;
import com.example.andymaster.Android_Tetorials.A_RatingBar.RatingBar_Source_code;
import com.example.andymaster.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SeekBar_output extends AppCompatActivity {
    SeekBar seekBar;
    FloatingActionButton fa_source_btn ,fa_Gloassary_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aseek_bar);
        seekBar=findViewById(R.id.seekBar);
        fa_source_btn = findViewById(R.id.fa_source_Button);
        fa_Gloassary_btn = findViewById(R.id.fa_Glossary_Button);
        fa_source_btn.setOnClickListener(v -> startActivity(new Intent(SeekBar_output.this, SeekBar_source_code.class)));
        fa_Gloassary_btn.setOnClickListener(v -> {startActivity(new Intent(SeekBar_output.this , Radio_btn_Glossary.class));});

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                Toast.makeText(getApplicationContext(),"seekbar progress: "+progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}