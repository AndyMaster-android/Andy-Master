package com.example.andymaster.Android_Tetorials.A_btn;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class Button_XML extends Fragment {
    CodeView mCodeView ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String XML_code = "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"match_parent\"\n" +
                "    android:paddingBottom=\"@dimen/activity_vertical_margin\"\n" +
                "    android:paddingLeft=\"@dimen/activity_horizontal_margin\"\n" +
                "    android:paddingRight=\"@dimen/activity_horizontal_margin\"\n" +
                "    android:paddingTop=\"@dimen/activity_vertical_margin\"\n" +
                "    tools:context=\".MainActivity\">\n" +
                "\n" +
                "    <Button\n" +
                "        android:id=\"@+id/simpleButton1\"\n" +
                "        android:layout_width=\"fill_parent\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_centerHorizontal=\"true\"\n" +
                "        android:layout_marginTop=\"100dp\"\n" +
                "        android:background=\"#00f\"\n" +
                "        android:drawableRight=\"@drawable/ic_launcher\"\n" +
                "        android:hint=\"Any Master Button1\"\n" +
                "        android:padding=\"5dp\"\n" +
                "        android:textColorHint=\"#fff\"\n" +
                "        android:textSize=\"20sp\"\n" +
                "        android:textStyle=\"bold|italic\" />\n </RelativeLayout>";

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button__x_m_l, container, false);
        mCodeView = view.findViewById(R.id.codeView);
        GoSyntaxManager.applyMonokaiTheme(getContext(), mCodeView);
        mCodeView.setText(XML_code);

        return view;
    }
}