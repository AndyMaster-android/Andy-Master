package com.example.andymaster.Android_Tetorials.A_Spinner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class Spinner_java extends Fragment {
    CodeView mCodeView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String java_code = "import android.support.v7.app.AppCompatActivity;\n" +
                "import android.widget.AdapterView;\n" +
                "import android.view.View;\n" +
                "import android.os.Bundle;\n" +
                "import android.widget.ArrayAdapter;\n" +
                "import android.widget.Spinner;\n" +
                "import android.os.Bundle;\n" +
                "\n" +
                "// Main Activity implements Adapter view\n" +
                "public class MainActivity\n" +
                "\textends AppCompatActivity\n" +
                "\timplements AdapterView.OnItemSelectedListener {\n" +
                "\n" +
                "\t// create array of Strings\n" +
                "\t// and store name of courses\n" +
                "\tString[] courses = { \"Android Development\", \"Data structures\",\n" +
                "\t\t\t\t\t\t\"Interview prep\", \"Algorithms\",\n" +
                "\t\t\t\t\t\t\"DSA with java\", \"OS\" };\n" +
                "\n" +
                "\t@Override\n" +
                "\tprotected void onCreate(Bundle savedInstanceState)\n" +
                "\t{\n" +
                "\t\tsuper.onCreate(savedInstanceState);\n" +
                "\t\tsetContentView(R.layout.activity_main);\n" +
                "\n" +
                "\t\t// Take the instance of Spinner and\n" +
                "\t\t// apply OnItemSelectedListener on it which\n" +
                "\t\t// tells which item of spinner is clicked\n" +
                "\t\tSpinner spino = findViewById(R.id.coursesspinner);\n" +
                "\t\tspin.setOnItemSelectedListener(this);\n" +
                "\n" +
                "\t\t// Create the instance of ArrayAdapter\n" +
                "\t\t// having the list of courses\n" +
                "\t\tArrayAdapter ad\n" +
                "\t\t\t= new ArrayAdapter(\n" +
                "\t\t\t\tthis,\n" +
                "\t\t\t\tandroid.R.layout.simple_spinner_item,\n" +
                "\t\t\t\tcourses);\n" +
                "\n" +
                "\t\t// set simple layout resource file\n" +
                "\t\t// for each item of spinner\n" +
                "\t\tad.setDropDownViewResource(\n" +
                "\t\t\tandroid.R.layout\n" +
                "\t\t\t\t.simple_spinner_dropdown_item);\n" +
                "\n" +
                "\t\t// Set the ArrayAdapter (ad) data on the\n" +
                "\t\t// Spinner which binds data to spinner\n" +
                "\t\tspino.setAdapter(ad);\n" +
                "\t}\n" +
                "\n" +
                "\t// Performing action when ItemSelected\n" +
                "\t// from spinner, Overriding onItemSelected method\n" +
                "\t@Override\n" +
                "\tpublic void onItemSelected(AdapterView<*> arg0,\n" +
                "\t\t\t\t\t\t\tView arg1,\n" +
                "\t\t\t\t\t\t\tint position,\n" +
                "\t\t\t\t\t\t\tlong id)\n" +
                "\t{\n" +
                "\n" +
                "\t\t// make toastof name of course\n" +
                "\t\t// which is selected in spinner\n" +
                "\t\tToast.makeText(getApplicationContext(),\n" +
                "\t\t\t\t\tcourses[position],\n" +
                "\t\t\t\t\tToast.LENGTH_LONG)\n" +
                "\t\t\t.show();\n" +
                "\t}\n" +
                "\n" +
                "\t@Override\n" +
                "\tpublic void onNothingSelected(AdapterView<*> arg0)\n" +
                "\t{\n" +
                "\t\t// Auto-generated method stub\n" +
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
