package com.example.andymaster.Android_Tetorials.A_DataPicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class DatePicker_java extends Fragment {
    CodeView mCodeView ;
    GoSyntaxManager goSyntaxManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String java_code = " package com.andymaster.Datepicker;\n" +
                "\n" +
                "import android.app.DatePickerDialog;\n" +
                "import android.os.Bundle;\n" +
                "import android.view.View;\n" +
                "import android.widget.Button;\n" +
                "import android.widget.DatePicker;\n" +
                "import android.widget.TextView;\n" +
                "import androidx.appcompat.app.AppCompatActivity;\n" +
                "import java.util.Calendar;\n" +
                "\n" +
                "public class MainActivity extends AppCompatActivity {\n" +
                "\n" +
                "\t// on below line we are creating variables.\n" +
                "\tprivate Button pickDateBtn;\n" +
                "\tprivate TextView selectedDateTV;\n" +
                "\n" +
                "\t@Override\n" +
                "\tprotected void onCreate(Bundle savedInstanceState) {\n" +
                "\t\tsuper.onCreate(savedInstanceState);\n" +
                "\t\tsetContentView(R.layout.activity_main);\n" +
                "\n" +
                "\t\t// on below line we are initializing our variables.\n" +
                "\t\tpickDateBtn = findViewById(R.id.idBtnPickDate)\n" +
                "\t\tselectedDateTV = findViewById(R.id.idTVSelectedDate)\n" +
                "\n" +
                "\t\t// on below line we are adding click listener for our pick date button\n" +
                "\t\tpickDateBtn.setOnClickListener(new View.OnClickListener() {\n" +
                "\t\t\t@Override\n" +
                "\t\t\tpublic void onClick(View v) {\n" +
                "\t\t\t\t// on below line we are getting\n" +
                "\t\t\t\t// the instance of our calendar.\n" +
                "\t\t\t\tfinal Calendar c = Calendar.getInstance();\n" +
                "\n" +
                "\t\t\t\t// on below line we are getting\n" +
                "\t\t\t\t// our day, month and year.\n" +
                "\t\t\t\tint year = c.get(Calendar.YEAR);\n" +
                "\t\t\t\tint month = c.get(Calendar.MONTH);\n" +
                "\t\t\t\tint day = c.get(Calendar.DAY_OF_MONTH);\n" +
                "\n" +
                "\t\t\t\t// on below line we are creating a variable for date picker dialog.\n" +
                "\t\t\t\tDatePickerDialog datePickerDialog = new DatePickerDialog(\n" +
                "\t\t\t\t\t\t// on below line we are passing context.\n" +
                "\t\t\t\t\t\tMainActivity.this,\n" +
                "\t\t\t\t\t\tnew DatePickerDialog.OnDateSetListener() {\n" +
                "\t\t\t\t\t\t\t@Override\n" +
                "\t\t\t\t\t\t\tpublic void onDateSet(DatePicker view, int year,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tint monthOfYear, int dayOfMonth) {\n" +
                "\t\t\t\t\t\t\t\t// on below line we are setting date to our text view.\n" +
                "\t\t\t\t\t\t\t\tselectedDateTV.setText(dayOfMonth + \"-\" + (monthOfYear + 1) + \"-\" + year);\n" +
                "\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t// on below line we are passing year,\n" +
                "\t\t\t\t\t\t// month and day for selected date in our date picker.\n" +
                "\t\t\t\t\t\tyear, month, day);\n" +
                "\t\t\t\t// at last we are calling show to\n" +
                "\t\t\t\t// display our date picker dialog.\n" +
                "\t\t\t\tdatePickerDialog.show();\n" +
                "\t\t\t}\n" +
                "\t\t});\n" +
                "\t}\n" +
                "}\n";

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button_java, container, false);
        mCodeView = view.findViewById(R.id.codeView);
        GoSyntaxManager.applyMonokaiTheme(getContext(), mCodeView);
        mCodeView.setText(java_code);
        mCodeView.cancelLongPress();
        mCodeView.cancelPendingInputEvents();
        return view;
    }
}
