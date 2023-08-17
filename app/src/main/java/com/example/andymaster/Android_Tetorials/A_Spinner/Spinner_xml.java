package com.example.andymaster.Android_Tetorials.A_Spinner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class Spinner_xml extends Fragment {
    CodeView mCodeView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String java_code = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<androidx.constraintlayout.widget.ConstraintLayout\n xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"match_parent\"\n" +
                "    tools:context=\".Android_Tetorials.A_Spinner.Spinner_output\">\n" +
                "    \n" +
                "    <Spinner\n" +
                "        android:id=\"@+id/spinner\"\n" +
                "        android:layout_width=\"149dp\"\n" +
                "        android:layout_height=\"40dp\"\n" +
                "        android:layout_marginBottom=\"8dp\"\n" +
                "        android:layout_marginEnd=\"8dp\"\n" +
                "        android:layout_marginStart=\"8dp\"\n" +
                "        android:layout_marginTop=\"8dp\"\n" +
                "        app:layout_constraintBottom_toBottomOf=\"parent\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"parent\"\n" +
                "        app:layout_constraintHorizontal_bias=\"0.502\"\n" +
                "        app:layout_constraintStart_toStartOf=\"parent\"\n" +
                "        app:layout_constraintTop_toTopOf=\"parent\"\n" +
                "        app:layout_constraintVertical_bias=\"0.498\" />\n"+
                "\n"+
                "</androidx.constraintlayout.widget.ConstraintLayout>";

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
