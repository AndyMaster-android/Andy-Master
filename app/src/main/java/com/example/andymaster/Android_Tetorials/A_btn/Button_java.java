package com.example.andymaster.Android_Tetorials.A_btn;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;



public class Button_java extends Fragment {
    CodeView mCodeView ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String java_code = "package example.AndyMaster.buttonexample;\n" +
                "\n" +
                "import android.support.v7.app.AppCompatActivity;\n" +
                "import android.os.Bundle;\n" +
                "import android.view.View;\n" +
                "import android.widget.Button;\n" +
                "import android.widget.Toast;\n" +
                "\n" +
                "public class MainActivity extends AppCompatActivity {\n" +
                "\n" +
                "    Button simpleButton1;\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        simpleButton1 = (Button) findViewById(R.id.simpleButton1);//get id of button 1\n" +
                "\n" +
                "        simpleButton1.setOnClickListener(new View.OnClickListener() {\n" +
                "            @Override\n" +
                "            public void onClick(View view) {\n" +
                "                Toast.makeText(getApplicationContext(), \"Simple Button 1\", Toast.LENGTH_LONG).show();\n" +
                "            }\n" +
                "        });\n" +

                "    }\n" +
                "\n" +
                "    \n" +
                "}";

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