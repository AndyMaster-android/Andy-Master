package com.example.andymaster.Android_Tetorials.A_Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.andymaster.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Switch_btn_output extends AppCompatActivity {
    SwitchCompat aSwitch;
    TextView textView;
    FloatingActionButton fa_source_btn ,fa_Gloassary_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_btn_output);
        fa_source_btn = findViewById(R.id.switch_btn_code);
        fa_Gloassary_btn = findViewById(R.id.fa_Glossary_Btn);
        aSwitch =findViewById(R.id.switch_btn);

        fa_source_btn.setOnClickListener(v -> startActivity(new Intent(Switch_btn_output.this, Switch_source_code.class)));
        fa_Gloassary_btn.setOnClickListener(v -> {startActivity(new Intent(Switch_btn_output.this , Glossary_Switch.class));});

    }

    public void onSwitchclick(View view) {
        textView = findViewById(R.id.text1);
        if (aSwitch.isChecked()){
            textView.setText("Switch is ON");
            textView.setTextColor(getResources().getColor(R.color.monokia_pro_green));
        }
        else {
            textView.setText("Switch is OFF");
            textView.setTextColor(getResources().getColor(R.color.black));
        }
    }
}