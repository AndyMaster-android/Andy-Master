package com.example.andymaster.Android_Tetorials.A_RatingBar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class RatingBar_java extends Fragment {
    CodeView mCodeView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String java_code = "      package com.example.andymaster.A_RatingBar;\n" +
                "\n" +
                "import androidx.appcompat.app.AppCompatActivity;\n" +
                "\n" +
                "import android.content.Intent;\n" +
                "import android.os.Bundle;\n" +
                "import android.widget.Button;\n" +
                "import android.widget.Toast;\n" +
                "\n" +
                "import com.example.andymaster.R;\n" +
                "\n" +
                "public class RatingBar extends AppCompatActivity {\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_ratin_bar);" +
                "        final RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.simpleRatingBar);\n" +
                "        Button submitButton = (Button) findViewById(R.id.submitButton);\n" +
                "        // perform click event on button\n" +
                "        submitButton.setOnClickListener(new View.OnClickListener() {\n" +
                "            @Override\n" +
                "            public void onClick(View v) {\n" +
                "                // get values and then displayed in a toast\n" +
                "                String totalStars = \"Total Stars:: \" + simpleRatingBar.getNumStars();\n" +
                "                String rating = \"Rating :: \" + simpleRatingBar.getRating();\n" +
                "                Toast.makeText(getApplicationContext(), totalStars + \"\\n\" + rating, Toast.LENGTH_LONG).show();\n" +
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
        mCodeView.setText(java_code);
        mCodeView.cancelLongPress();
        mCodeView.cancelPendingInputEvents();
        return view;
    }
}
