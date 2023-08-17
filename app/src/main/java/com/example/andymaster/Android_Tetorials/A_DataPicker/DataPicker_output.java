package com.example.andymaster.Android_Tetorials.A_DataPicker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.andymaster.Android_Tetorials.A_TimePicker.TimePicker_Glossary;
import com.example.andymaster.Android_Tetorials.A_TimePicker.TimePicker_output;
import com.example.andymaster.Android_Tetorials.A_TimePicker.TimePicker_source_code;
import com.example.andymaster.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class DataPicker_output extends AppCompatActivity {
    private Button pickDateBtn;
    private TextView selectedDateTV;
    FloatingActionButton fa_source_btn ,fa_Gloassary_btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_picker_output);
        fa_source_btn = findViewById(R.id.fa_source_Button);
        fa_Gloassary_btn = findViewById(R.id.fa_Glossary_Button);
        fa_source_btn.setOnClickListener(v -> { startActivity(new Intent(DataPicker_output.this , DataPicker_source_code.class));});
        fa_Gloassary_btn.setOnClickListener(v -> {startActivity(new Intent(DataPicker_output.this , DataPicker_Glossary.class));});

        // on below line we are initializing our variables.
        pickDateBtn = findViewById(R.id.idBtnPickDate);
        selectedDateTV = findViewById(R.id.idTVSelectedDate);

        // on below line we are adding click listener for our pick date button
        pickDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        DataPicker_output.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                selectedDateTV.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
            }
        });
    }
}