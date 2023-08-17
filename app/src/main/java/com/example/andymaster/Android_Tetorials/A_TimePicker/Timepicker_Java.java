package com.example.andymaster.Android_Tetorials.A_TimePicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class Timepicker_Java extends Fragment {
    CodeView mCodeView ;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String JAVA_CODE = "package com.example.andymaster.TimePicker;\n" +
                "\n" +
                "import androidx.appcompat.app.AppCompatActivity;\n" +
                "\n" +
                "import android.app.TimePickerDialog;\n" +
                "import android.content.Intent;\n" +
                "import android.os.Bundle;\n" +
                "import android.view.View;\n" +
                "import android.widget.Button;\n" +
                "import android.widget.TextView;\n" +
                "import android.widget.TimePicker;\n" +
                "import com.example.andymaster.R;\n" +
                "\n" +
                "import java.util.Calendar;\n" +
                "\n" +
                "public class TimePicker_output extends AppCompatActivity {\n" +
                "    private Button pickTimeBtn;\n" +
                "    private TextView selectedTimeTV;\n"+
                "  // on below line we are initializing our variables.\n" +
                "        pickTimeBtn = findViewById(R.id.idBtnPickTime);\n" +
                "        selectedTimeTV = findViewById(R.id.idTVSelectedTime);\n" +
                " @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_time_picker_output);\n"+
                "\n" +
                "        // on below line we are adding click\n" +
                "        // listener for our pick date button\n" +
                "        pickTimeBtn.setOnClickListener(new View.OnClickListener() {\n" +
                "            @Override\n" +
                "            public void onClick(View v) {\n" +
                "                // on below line we are getting the\n" +
                "                // instance of our calendar.\n" +
                "                final Calendar c = Calendar.getInstance();\n" +
                "\n" +
                "                // on below line we are getting our hour, minute.\n" +
                "                int hour = c.get(Calendar.HOUR_OF_DAY);\n" +
                "                int minute = c.get(Calendar.MINUTE);\n" +
                "\n" +
                "                // on below line we are initializing our Time Picker Dialog\n" +
                "                TimePickerDialog timePickerDialog = new TimePickerDialog(TimePicker_output.this,\n" +
                "                        new TimePickerDialog.OnTimeSetListener() {\n" +
                "                            @Override\n" +
                "                            public void onTimeSet(TimePicker view, int hourOfDay,\n" +
                "                                                  int minute) {\n" +
                "                                // on below line we are setting selected time\n" +
                "                                // in our text view.\n" +
                "                                selectedTimeTV.setText(hourOfDay + \":\" + minute);\n" +
                "                            }\n" +
                "                        }, hour, minute, false);\n" +
                "                // at last we are calling show to\n" +
                "                // display our time picker dialog.\n" +
                "                timePickerDialog.show();\n" +
                "            }\n" +
                "        });\n" +
                "    }\n" +
                "}";

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button_java, container, false);

        mCodeView = view.findViewById(R.id.codeView);
        GoSyntaxManager.applyMonokaiTheme(getContext(), mCodeView);
        mCodeView.setText(JAVA_CODE);
        return view;
    }
}
