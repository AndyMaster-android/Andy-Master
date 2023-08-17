package com.example.andymaster.Android_Tetorials.A_ProgressBar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class ProgressBar_xml extends Fragment {
    CodeView mCodeView ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String XML_code = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<androidx.constraintlayout.widget.ConstraintLayout \n xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:background=\"@color/black_overlay\"\n" +
                "    android:layout_height=\"match_parent\" tools:context=\"ProgressBar_output\">\n" +
                "\n" +
                "    <androidx.appcompat.widget.AppCompatButton\n" +
                "        android:id=\"@+id/btnStartProgress\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:background=\"@drawable/next_btn\"\n" +
                "        app:layout_constraintBottom_toBottomOf=\"parent\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"parent\"\n" +
                "        app:layout_constraintHorizontal_bias=\"0.498\"\n" +
                "        app:layout_constraintStart_toStartOf=\"parent\"\n" +
                "        app:layout_constraintTop_toTopOf=\"parent\"\n" +
                "        app:layout_constraintVertical_bias=\"0.829\" />\n"+
                "</androidx.constraintlayout.widget.ConstraintLayout>";

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button__x_m_l, container, false);
        mCodeView = view.findViewById(R.id.codeView);
        GoSyntaxManager.applyMonokaiTheme(getContext(), mCodeView);
        mCodeView.setText(XML_code);

        return view;
    }
}
