package com.example.andymaster.Android_Tetorials.A_RatingBar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.andymaster.Android_Tetorials.A_Radio_btn.Radio_btn;
import com.example.andymaster.Android_Tetorials.A_Radio_btn.Radio_btn_Glossary;
import com.example.andymaster.Android_Tetorials.A_Radio_btn.Radio_btn_source_code;
import com.example.andymaster.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RatingBar extends AppCompatActivity {
    FloatingActionButton fa_source_btn ,fa_Gloassary_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratin_bar);

        fa_source_btn = findViewById(R.id.fa_source_Button);
        fa_Gloassary_btn = findViewById(R.id.fa_Glossary_Button);
        Button submitButton = (Button) findViewById(R.id.submitButton);
         android.widget.RatingBar simpleRatingBar = (android.widget.RatingBar) findViewById(R.id.simpleRatingBar);

        // perform click event on button
        submitButton.setOnClickListener(v -> {
            // get values and then displayed in a toast
            String totalStars = "Total Stars:: " + simpleRatingBar.getNumStars();
            String rating = "Rating :: " + simpleRatingBar.getRating();
            Toast.makeText(getApplicationContext(), totalStars + "\n" + rating, Toast.LENGTH_LONG).show();
        });
        fa_source_btn.setOnClickListener(v -> startActivity(new Intent(RatingBar.this, RatingBar_Source_code.class)));
        fa_Gloassary_btn.setOnClickListener(v -> {startActivity(new Intent(RatingBar.this , Radio_btn_Glossary.class));});

    }
    }
