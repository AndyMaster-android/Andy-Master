package com.example.andymaster.Android_Tetorials.A_Radio_btn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class Radio_btn_xml extends Fragment {
    CodeView mCodeView ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String java_code = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"match_parent\"\n" +
                "    tools:context=\"Radio_btn\">\n" +
                "\n" +
                "    <RadioGroup\n" +
                "        android:id=\"@+id/radioGroup\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        app:layout_constraintBottom_toBottomOf=\"parent\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"parent\"\n" +
                "        app:layout_constraintStart_toStartOf=\"parent\"\n" +
                "        app:layout_constraintTop_toTopOf=\"parent\">\n" +
                "\n" +
                "    <RadioButton\n" +
                "        android:id=\"@+id/lionel_messi\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_marginBottom=\"36dp\"\n" +
                "        android:checked=\"true\"\n" +
                "        android:text=\"lionel messi\"\n" +
                "        android:textColor=\"#154\"\n" +
                "        android:textSize=\"20sp\"\n" +
                "        android:textStyle=\"bold\"\n" +
                "        app:layout_constraintBottom_toTopOf=\"@+id/radioGroup\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"@+id/radioGroup\"\n" +
                "        app:layout_constraintHorizontal_bias=\"1.0\"\n" +
                "        app:layout_constraintStart_toStartOf=\"@+id/radioGroup\" />\n" +
                "\n" +
                "    <RadioButton\n" +
                "        android:id=\"@+id/Cristiano_Ronaldo\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_marginBottom=\"36dp\"\n" +
                "        android:checked=\"false\"\n" +
                "        android:text=\"Cristiano Ronaldo\"\n" +
                "        android:textColor=\"#154\"\n" +
                "        android:textSize=\"20sp\"\n" +
                "        android:textStyle=\"bold\"\n" +
                "        app:layout_constraintBottom_toTopOf=\"@+id/johnCena\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"@+id/johnCena\"\n" +
                "        app:layout_constraintHorizontal_bias=\"0.0\"\n" +
                "        app:layout_constraintStart_toStartOf=\"@+id/johnCena\" />\n" +
                "    </RadioGroup> \n" +
                "\n" +
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
