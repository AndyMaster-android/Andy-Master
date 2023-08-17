package com.example.andymaster.Android_Tetorials.A_TextView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class TextView_xml extends Fragment {
    CodeView mCodeView , mcode2;
    GoSyntaxManager goSyntaxManager;
    public TextView_xml() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String XML_CODE = "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"match_parent\"\n" +
                "    android:paddingBottom=\"@dimen/activity_vertical_margin\"\n" +
                "    android:paddingLeft=\"@dimen/activity_horizontal_margin\"\n" +
                "    android:paddingRight=\"@dimen/activity_horizontal_margin\"\n" +
                "    android:paddingTop=\"@dimen/activity_vertical_margin\"\n" +
                "    tools:context=\".MainActivity\">\n" +
                "\n" +
                "    <TextView\n" +
                "        android:id=\"@+id/simpleTextView\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_centerHorizontal=\"true\"\n" +
                "        android:text=\"Before Clicking\"\n" +
                "        android:textColor=\"#f00\"\n" +
                "        android:textSize=\"25sp\"\n" +
                "        android:textStyle=\"bold|italic\"\n" +
                "        android:layout_marginTop=\"50dp\"/>";

        // Inflate the layout for this fragment


         View view =inflater.inflate(R.layout.fragment_button__x_m_l, container, false);
        mCodeView = view.findViewById(R.id.codeView);
        GoSyntaxManager.applyMonokaiTheme(getContext(), mCodeView);
        mCodeView.setText(XML_CODE);
         return view;
    }
}