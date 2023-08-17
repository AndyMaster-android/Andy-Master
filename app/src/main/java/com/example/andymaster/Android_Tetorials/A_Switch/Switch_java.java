package com.example.andymaster.Android_Tetorials.A_Switch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class Switch_java extends Fragment {
    CodeView mCodeView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String java_code = "package example.AndyMaster.switchexample;\n" +
                "\n" +
                "import android.support.v7.app.AppCompatActivity;\n" +
                "import android.os.Bundle;\n" +
                "import android.view.View;\n" +
                "import android.widget.Button;\n" +
                "import android.widget.Switch;\n" +
                "import android.widget.Toast;\n" +
                "\n" +
                "public class MainActivity extends AppCompatActivity {\n" +
                "\n" +
                "    Switch aSwitch;\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        // initiate view's\n" +
                "        aSwitch = (Switch) findViewById(R.id.switch_btn);" +
                "public void onSwitchclick(View view) {\n" +
                "        textView = findViewById(R.id.text1);\n" +
                "        if (aSwitch.isChecked()){\n" +
                "            textView.setText(\"Switch is ON\");\n" +
                "            textView.setTextColor(getResources().getColor(R.color.monokia_pro_green));\n" +
                "        }\n" +
                "        else {\n" +
                "            textView.setText(\"Switch is OFF\");\n" +
                "            textView.setTextColor(getResources().getColor(R.color.black));\n" +
                "        }\n" +
                "    }";

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
