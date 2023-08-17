package com.example.andymaster.Android_Tetorials.A_SeekBar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class SeekBar_java extends Fragment {
    CodeView mCodeView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String java_code = "package com.example.andymaster.A_SeekBar;\n" +
                "\n" +
                "import androidx.appcompat.app.AppCompatActivity;\n" +
                "\n" +
                "import android.content.Intent;\n" +
                "import android.os.Bundle;\n" +
                "import android.view.View;\n" +
                "import android.widget.SeekBar;\n" +
                "import android.widget.Toast;\n" +
                "\n" +
                "\n" +
                "public class SeekBar_output extends AppCompatActivity {\n" +
                "    SeekBar seekBar;"+
                " @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_aseek_bar);\n" +
                "        seekBar=findViewById(R.id.seekBar);\n"+
                "  seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {\n" +
                "            @Override\n" +
                "            public void onProgressChanged(SeekBar seekBar, int progress,\n" +
                "                                          boolean fromUser) {\n" +
                "                Toast.makeText(getApplicationContext(),\"seekbar progress: \"+progress, Toast.LENGTH_SHORT).show();\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void onStartTrackingTouch(SeekBar seekBar) {\n" +
                "                Toast.makeText(getApplicationContext(),\"seekbar touch started!\", Toast.LENGTH_SHORT).show();\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void onStopTrackingTouch(SeekBar seekBar) {\n" +
                "                Toast.makeText(getApplicationContext(),\"seekbar touch stopped!\", Toast.LENGTH_SHORT).show();\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "    }\n" +
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
