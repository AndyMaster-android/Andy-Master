package com.example.andymaster.Android_Tetorials.A_Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.andymaster.Android_Tetorials.A_btn.Button_Glossary;
import com.example.andymaster.Android_Tetorials.A_btn.Button_output;
import com.example.andymaster.Android_Tetorials.A_btn.Button_source_code;
import com.example.andymaster.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Spinner_output extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    FloatingActionButton fa_source_btn ,fa_Gloassary_btn;


        // create array of Strings
        // and store name of courses
        String[] courses = { "Android Development", "Data structures",
                "Interview prep", "Algorithms",
                "DSA with java", "Flutter" };

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_output);
            Spinner spin = (Spinner) findViewById(R.id.spinner);


    fa_source_btn = findViewById(R.id.fa_source_Button);
        fa_Gloassary_btn = findViewById(R.id.fa_Glossary_Button);
        fa_source_btn.setOnClickListener(v -> startActivity(new Intent(Spinner_output.this, Spinner_source_code.class)));
        fa_Gloassary_btn.setOnClickListener(v -> {startActivity(new Intent(Spinner_output.this , Spinner_Glossary.class));});


            spin.setOnItemSelectedListener(this);

            ArrayAdapter ad = new ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item,courses);
            spin.setAdapter(ad);
        }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),
                        courses[position],
                        Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


