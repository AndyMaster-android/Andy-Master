package com.example.andymaster.Android_Tetorials.A_Radio_btn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class Radio_java extends Fragment {
    CodeView mCodeView ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String java_code = "package com.example.andymaster.Android_Tetorials.A_Radio_btn;\n" +
                "\n" +
                "import androidx.appcompat.app.AppCompatActivity;\n" +
                "\n" +
                "import android.annotation.SuppressLint;\n" +
                "import android.content.Intent;\n" +
                "import android.os.Bundle;\n" +
                "import android.view.View;\n" +
                "import android.widget.RadioButton;\n" +
                "import android.widget.Toast;\n" +
                "\n" +
                "\n" +
                "public class Radio_btn extends AppCompatActivity {\n" +
                "    RadioButton massi , renaldo;\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_radio_btn);\n"+
                " massi =findViewById(R.id.lionel_messi);\n" +
                "        renaldo =findViewById(R.id.Cristiano_Ronaldo);\n" +
                "        massi.setOnClickListener(v -> Toast.makeText(Radio_btn.this, \"\"+massi.getText().toString(),\n Toast.LENGTH_SHORT).show());\n" +
                "       renaldo.setOnClickListener(v -> {Toast.makeText(this, \"\"+renaldo.getText().toString(),\n Toast.LENGTH_SHORT).show();});\n"+
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
