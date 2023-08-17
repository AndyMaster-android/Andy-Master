package com.example.andymaster.Android_Tetorials.A_webView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class WebView_java extends Fragment {
    CodeView mCodeView, mcode2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String Java_CODE = "package com.example.andymaster.A_webView;\n" +
                "\n" +
                "import androidx.appcompat.app.AppCompatActivity;\n" +
                "\n" +
                "import android.content.Intent;\n" +
                "import android.os.Bundle;\n" +
                "import android.view.View;\n" +
                "import android.webkit.WebView;\n" +
                "import android.webkit.WebViewClient;\n" +
                "\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_web_view);\n" +
        " // Find the WebView by its unique ID\n" +
                "        WebView webView = findViewById(R.id.web);\n" +
                "        btnStart = findViewById(R.id.btnStartProgress);\n" +
                "        btnStart.setOnClickListener(v -> {\n" +
                "\n" +
                "            webView.loadUrl(\"https://www.google.com/\");\n" +
                "            btnStart.setVisibility(View.GONE);\n" +
                "            // this will enable the javascript.\n" +
                "            webView.getSettings().setJavaScriptEnabled(true);\n" +
                "\n" +
                "            // WebViewClient allows you to handle\n" +
                "            // onPageFinished and override Url loading.\n" +
                "            webView.setWebViewClient(new WebViewClient());" ;

        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_button__x_m_l, container, false);
        mCodeView = view.findViewById(R.id.codeView);
        GoSyntaxManager.applyMonokaiTheme(getContext(), mCodeView);
        mCodeView.setText(Java_CODE);
        return view;
    }
}
