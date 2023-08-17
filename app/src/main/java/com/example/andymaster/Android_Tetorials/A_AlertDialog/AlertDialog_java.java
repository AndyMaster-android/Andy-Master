package com.example.andymaster.Android_Tetorials.A_AlertDialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class AlertDialog_java extends Fragment {
    CodeView mCodeView ;
    GoSyntaxManager goSyntaxManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String java_code = "package com.example.andymaster.AlertDialog;\n" +
                "\n" +
                "import androidx.appcompat.app.AlertDialog;\n" +
                "import androidx.appcompat.app.AppCompatActivity;\n" +
                "\n" +
                "import android.annotation.SuppressLint;\n" +
                "import android.content.DialogInterface;\n" +
                "import android.content.Intent;\n" +
                "import android.os.Bundle;\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_alert_dialog_output);\n"+
                "  }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onBackPressed() {\n" +
                "        AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialog_output.this);\n" +
                "\n" +
                "        // Set the message show for the Alert time\n" +
                "        builder.setMessage(\"Do you want to exit ?\");\n" +
                "\n" +
                "        // Set Alert Title\n" +
                "        builder.setTitle(\"Alert !\");\n" +
                "\n" +
                "        // Set Cancelable false for when the user clicks\n on the outside the Dialog Box then it will remain show\n" +
                "        builder.setCancelable(false);\n" +
                "\n" +
                "        // Set the positive button with yes name Lambda \nOnClickListener method is use of DialogInterface interface.\n" +
                "        builder.setPositiveButton(\"Yes\", (DialogInterface.OnClickListener) (dialog, which) -> {\n" +
                "            // When the user click yes button then app will close\n" +
                "            finish();\n" +
                "        });\n" +
                "\n" +
                "        // Set the Negative button with No name Lambda \nOnClickListener method is use of DialogInterface interface.\n" +
                "        builder.setNegativeButton(\"No\", (DialogInterface.OnClickListener) (dialog, which) -> {\n" +
                "            // If user click no then dialog box is canceled.\n" +
                "            dialog.cancel();\n" +
                "        });\n" +
                "\n" +
                "        // Create the Alert dialog\n" +
                "        AlertDialog alertDialog = builder.create();\n" +
                "        // Show the Alert Dialog box\n" +
                "        alertDialog.show();\n" +
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
