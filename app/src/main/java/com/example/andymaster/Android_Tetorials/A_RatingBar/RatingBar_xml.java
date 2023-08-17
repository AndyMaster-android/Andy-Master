package com.example.andymaster.Android_Tetorials.A_RatingBar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class RatingBar_xml extends Fragment {
    CodeView mCodeView ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String xml_code = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"match_parent\"\n" +
                "    tools:context=\".Android_Tetorials.A_RatingBar.RatingBar\">\n" +
                "\n" +
                "    <RatingBar\n" +
                "        android:id=\"@+id/simpleRatingBar\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_centerHorizontal=\"true\"\n" +
                "        android:layout_marginBottom=\"80dp\"\n" +
                "        android:background=\"@drawable/quiz_btn\"\n" +
                "        android:paddingLeft=\"5dp\"\n" +
                "        android:paddingRight=\"5dp\"\n" +
                "        android:rating=\"2\"\n" +
                "        app:layout_constraintBottom_toTopOf=\"@+id/submitButton\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"@+id/submitButton\"\n" +
                "        app:layout_constraintStart_toStartOf=\"@+id/submitButton\" />\n" +
                "\n" +
                "    <Button\n" +
                "        android:id=\"@+id/submitButton\"\n" +
                "        android:layout_width=\"200dp\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_centerInParent=\"true\"\n" +
                "        android:background=\"#f00\"\n" +
                "        android:padding=\"10dp\"\n" +
                "        android:text=\"Submit\"\n" +
                "        android:textColor=\"#fff\"\n" +
                "        android:textSize=\"20sp\"\n" +
                "        android:textStyle=\"bold\"\n" +
                "        app:layout_constraintBottom_toBottomOf=\"parent\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"parent\"\n" +
                "        app:layout_constraintHorizontal_bias=\"0.497\"\n" +
                "        app:layout_constraintStart_toStartOf=\"parent\"\n" +
                "        app:layout_constraintTop_toTopOf=\"parent\"\n" +
                "        app:layout_constraintVertical_bias=\"0.365\" />\n" +
                "\n" +
                "</androidx.constraintlayout.widget.ConstraintLayout>";

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button_java, container, false);
        mCodeView = view.findViewById(R.id.codeView);
        GoSyntaxManager.applyMonokaiTheme(getContext(), mCodeView);
        mCodeView.setText(xml_code);
        mCodeView.cancelLongPress();
        mCodeView.cancelPendingInputEvents();
        return view;
    }
}
