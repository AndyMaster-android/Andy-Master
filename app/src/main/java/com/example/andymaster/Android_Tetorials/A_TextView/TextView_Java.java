package com.example.andymaster.Android_Tetorials.A_TextView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class TextView_Java extends Fragment {
    CodeView mCodeView ;
    GoSyntaxManager goSyntaxManager;
    public TextView_Java() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String JAVA_CODE = "package example.AndyMaster.textviewexample;\n" +
                "\n" +
                "import android.graphics.Color;\n" +
                "import android.support.v7.app.AppCompatActivity;\n" +
                "import android.os.Bundle;\n" +
                "import android.view.Menu;\n" +
                "import android.view.MenuItem;\n" +
                "import android.view.View;\n" +
                "import android.widget.Button;\n" +
                "import android.widget.TextView;\n" +
                "\n" +
                "public class MainActivity extends AppCompatActivity {\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main); //set the layout\n" +
                "        final TextView simpleTextView = (TextView) findViewById(R.id.simpleTextView); //get the id for TextView\n" +
                "        TextView.setOnClickListener(new View.OnClickListener() {\n" +
                "            @Override\n" +
                "            public void onClick(View view) {\n" +
                "                simpleTextView.setText(\"After Clicking\"); //set the text after clicking button\n" +
                "            }\n" +
                "        });\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "}";

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button_java, container, false);

        mCodeView = view.findViewById(R.id.codeView);
        GoSyntaxManager.applyMonokaiTheme(getContext(), mCodeView);
        mCodeView.setText(JAVA_CODE);
        return view;
    }
}