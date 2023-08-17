package com.example.andymaster.Android_Courses.Ab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andymaster.R;

public class Get_Start_Ac extends AppCompatActivity {

    TextView DownloadJdk , DownloadAndroid;
    View Layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_start);
        Layout = findViewById(R.id.Layout);

        DownloadJdk = Layout.findViewById(R.id.Download_jdk);
        DownloadAndroid = Layout.findViewById(R.id.Android_studio);

        DownloadAndroid.setOnClickListener(v -> {
            String url = "https://developer.android.com/studio?gclid=CjwKCAjw5MOlBhBTEiwAAJ8e1hxGnJO1sV5cev-46m9Z4tIFQ-oyQIIUcE3ampLdpl6u1SsbCQj5gBoCje8QAvD_BwE&gclsrc=aw.ds";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        DownloadJdk.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            String url = "https://www.oracle.com/pk/java/technologies/downloads/";

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });

    }
}