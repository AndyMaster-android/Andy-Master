package com.example.andymaster.Android_Courses.Ab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andymaster.R;

public class intro_Android extends AppCompatActivity {

    ImageView canecel_btn;
    TextToSpeech textToSpeech;
    TextView Quiz , Quit_btn;
    Button  Keep_learning_btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_android);
        Quit_btn = findViewById(R.id.cancel_button);
        Quiz = findViewById(R.id.Quiz_btn);

        Quiz.setOnClickListener(v -> {
            startActivity(new Intent(intro_Android.this , intro_Quiz.class));

        });

        Dialog dialog = new Dialog(intro_Android.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_cancel);
        Quit_btn.setOnClickListener(v -> {
            Quit_btn = dialog.findViewById(R.id.btn_yes);
            Keep_learning_btn = dialog.findViewById(R.id.btn_no);
            Quit_btn.setOnClickListener(v1 -> {
                dialog.dismiss();
                finish();
            });
            Keep_learning_btn.setOnClickListener(v12 -> dialog.dismiss());
            dialog.show();
        });




    }
}