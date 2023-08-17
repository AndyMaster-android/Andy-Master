package com.example.andymaster.Android_Tetorials.A_EDitText;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class EditText_java_code extends Fragment {
    CodeView mCodeView ;
    GoSyntaxManager goSyntaxManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String java_code = "package example.AndyMaster.com.edittext;    \n" +
                "    \n" +
                "import android.support.v7.app.AppCompatActivity;    \n" +
                "import android.os.Bundle;    \n" +
                "import android.view.View;    \n" +
                "import android.widget.Button;    \n" +
                "import android.widget.EditText;    \n" +
                "import android.widget.Toast;    \n" +
                "    \n" +
                "public class MainActivity extends AppCompatActivity {    \n" +
                "    private EditText edittext1;    \n" +
                "    private Button buttonDisplay;    \n" +
                "    \n" +
                "    @Override    \n" +
                "    protected void onCreate(Bundle savedInstanceState) {    \n" +
                "        super.onCreate(savedInstanceState);    \n" +
                "        setContentView(R.layout.activity_main);    \n" +
                "    \n" +
                "        addListenerOnButton();    \n" +
                "    }    \n" +
                "    \n" +
                "    public void addListenerOnButton() {    \n" +
                "        edittext1 = findViewById(R.id.editText1);    \n" +
                "        buttonDisplay = findViewById(R.id.button);    \n" +
                "    \n" +
                "        buttonDisplay.setOnClickListener(new View.OnClickListener() {    \n" +
                "            @Override    \n" +
                "            public void onClick(View view) {    \n" +
                "                String value1=edittext1.getText().toString();    \n" +
                "                Toast.makeText(getApplicationContext(),value1\"\\n\", Toast.LENGTH_LONG).show();    \n" +
                "            }    \n" +
                "        });    \n" +
                "    }    \n" +
                "} ";

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
