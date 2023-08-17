package com.example.andymaster.Android_Tetorials.A_EDitText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.andymaster.Android_Tetorials.A_btn.Button_Glossary;
import com.example.andymaster.Android_Tetorials.A_btn.Button_output;
import com.example.andymaster.Android_Tetorials.A_btn.Button_source_code;
import com.example.andymaster.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EditText extends AppCompatActivity {

    AppCompatButton submit;
    android.widget.EditText name;
    FloatingActionButton fa_source_btn ,fa_Gloassary_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aedit_text);

        name = findViewById(R.id.editText1);
        submit = findViewById(R.id.submit);

        fa_source_btn = findViewById(R.id.fa_source_Button);
        fa_Gloassary_btn = findViewById(R.id.fa_Glossary_Button);


        submit.setOnClickListener(v -> Toast.makeText(EditText.this, "You Clicked  :"+name.getText().toString() , Toast.LENGTH_SHORT).show());
        fa_source_btn.setOnClickListener(v -> startActivity(new Intent(EditText.this, Edit_Text_source_code.class)));
        fa_Gloassary_btn.setOnClickListener(v -> {startActivity(new Intent(EditText.this , Edittext_Glossary.class));});

    }
}