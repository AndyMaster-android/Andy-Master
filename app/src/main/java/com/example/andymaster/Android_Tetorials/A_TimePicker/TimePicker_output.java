package com.example.andymaster.Android_Tetorials.A_TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import com.example.andymaster.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class TimePicker_output extends AppCompatActivity {
    private Button pickTimeBtn;
    private TextView selectedTimeTV;
    FloatingActionButton fa_source_btn ,fa_Gloassary_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_output);
        fa_source_btn = findViewById(R.id.fa_source_Button);
        fa_Gloassary_btn = findViewById(R.id.fa_Glossary_Button);
        fa_source_btn.setOnClickListener(v -> { startActivity(new Intent(TimePicker_output.this , TimePicker_source_code.class));});
        fa_Gloassary_btn.setOnClickListener(v -> {startActivity(new Intent(TimePicker_output.this , TimePicker_Glossary.class));});
        

        // on below line we are initializing our variables.
        pickTimeBtn = findViewById(R.id.idBtnPickTime);
        selectedTimeTV = findViewById(R.id.idTVSelectedTime);

        // on below line we are adding click
        // listener for our pick date button
        pickTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting the
                // instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting our hour, minute.
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                // on below line we are initializing our Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(TimePicker_output.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                // on below line we are setting selected time
                                // in our text view.
                                selectedTimeTV.setText(hourOfDay + ":" + minute);
                            }
                        }, hour, minute, false);
                // at last we are calling show to
                // display our time picker dialog.
                timePickerDialog.show();
            }
        });
    }
}