package com.example.andymaster.Android_Tetorials.A_webView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.andymaster.Android_Tetorials.A_ProgressBar.ProgressBar_Gloassory;
import com.example.andymaster.Android_Tetorials.A_ProgressBar.ProgressBar_output;
import com.example.andymaster.Android_Tetorials.A_ProgressBar.Progress_source_code;
import com.example.andymaster.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WebView_output extends AppCompatActivity {
    AppCompatButton btnStart;
    FloatingActionButton fa_source_btn ,fa_Gloassary_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_output);
        fa_source_btn = findViewById(R.id.fa_source_Button);
        fa_Gloassary_btn = findViewById(R.id.fa_Glossary_Button);

        fa_source_btn.setOnClickListener(v -> startActivity(new Intent(WebView_output.this, Webview_source_code.class)));
        fa_Gloassary_btn.setOnClickListener(v -> {startActivity(new Intent(WebView_output.this , ProgressBar_Gloassory.class));});

        // Find the WebView by its unique ID
        WebView webView = findViewById(R.id.web);
        btnStart = findViewById(R.id.btnStartProgress);
        btnStart.setOnClickListener(v -> {

            webView.loadUrl("https://www.google.com/");
            btnStart.setVisibility(View.GONE);
            // this will enable the javascript.
            webView.getSettings().setJavaScriptEnabled(true);

            // WebViewClient allows you to handle
            // onPageFinished and override Url loading.
            webView.setWebViewClient(new WebViewClient());
        });

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
