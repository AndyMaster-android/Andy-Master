package com.example.andymaster.Android_Tetorials.A_Toggale_btn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class Toggale_btn_java extends Fragment {
    CodeView mCodeView, mcode2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String Java_CODE = "package com.example.andymaster.Toggale_btn;\n" +
                "\n" +
                "import androidx.appcompat.app.AppCompatActivity;\n" +
                "\n" +
                "import android.content.Intent;\n" +
                "import android.os.Bundle;\n" +
                "import android.view.View;\n" +
                "import android.widget.Toast;\n" +
                "import android.widget.ToggleButton;\n" +
                "\n" +
                "public class Toggle_btn extends AppCompatActivity {\n" +
                "\n" +
                "    ToggleButton toggleButton;"+
                " @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_toggle_btn);\n" +
                "        toggleButton = findViewById(R.id.simpleToggleButton1);\n"+
                " toggleButton.setOnClickListener(new View.OnClickListener() {\n" +
                "            @Override\n" +
                "            public void onClick(View v) {\n" +
                "                toggleButton.setText(\"ON\");\n" +
                "                Toast.makeText(Toggle_btn.this, \"\"+ toggleButton.getText().toString(),\n Toast.LENGTH_SHORT).show();\n" +
                "            }\n" +
                "        });"+
        "    }\n" +
                "\n" +
                "\n" +
                "}" ;

        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_button__x_m_l, container, false);
        mCodeView = view.findViewById(R.id.codeView);
        GoSyntaxManager.applyMonokaiTheme(getContext(), mCodeView);
        mCodeView.setText(Java_CODE);
        return view;
    }
}
