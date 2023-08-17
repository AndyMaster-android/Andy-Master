package com.example.andymaster.Android_Tetorials.A_TimePicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class Timepicker_xml extends Fragment {

    CodeView mCodeView;


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
                "    tools:context=\".Android_Tetorials.A_TimePicker.TimePicker_output\">\n" +
                "\n" +
                "    <!--on below line we are creating\n" +
                "        a text for our app-->\n" +
                "\n" +
                "    <!--on below line we are creating a text view-->\n" +
                "\n" +
                "    <!--on below line we are creating a\n" +
                "        button for date picker-->\n" +
                "\n" +
                "    <TextView\n" +
                "        android:id=\"@+id/idTVHeading\"\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_above=\"@id/idTVSelectedTime\"\n" +
                "        android:layout_centerInParent=\"true\"\n" +
                "        android:layout_margin=\"20dp\"\n" +
                "        android:layout_marginBottom=\"64dp\"\n" +
                "        android:gravity=\"center\"\n" +
                "        android:padding=\"10dp\"\n" +
                "        android:text=\"Time Picker Dialog in Android\"\n" +
                "        android:textAlignment=\"center\"\n" +
                "        android:textColor=\"@color/black\"\n" +
                "        android:textSize=\"20sp\"\n" +
                "        android:textStyle=\"bold\"\n" +
                "        app:layout_constraintBottom_toTopOf=\"@+id/idTVSelectedTime\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"@+id/idTVSelectedTime\"\n" +
                "        app:layout_constraintHorizontal_bias=\"0.0\"\n" +
                "        app:layout_constraintStart_toStartOf=\"@+id/idTVSelectedTime\" />\n" +
                "\n" +
                "    <TextView\n" +
                "        android:id=\"@+id/idTVSelectedTime\"\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_above=\"@id/idBtnPickTime\"\n" +
                "        android:layout_centerInParent=\"true\"\n" +
                "        android:layout_margin=\"20dp\"\n" +
                "        android:layout_marginBottom=\"44dp\"\n" +
                "        android:gravity=\"center\"\n" +
                "        android:padding=\"10dp\"\n" +
                "        android:text=\"Time\"\n" +
                "        android:textAlignment=\"center\"\n" +
                "        android:textColor=\"@color/black\"\n" +
                "        android:textSize=\"20sp\"\n" +
                "        android:textStyle=\"bold\"\n" +
                "        app:layout_constraintBottom_toTopOf=\"@+id/idBtnPickTime\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"@+id/idBtnPickTime\"\n" +
                "        app:layout_constraintHorizontal_bias=\"0.0\"\n" +
                "        app:layout_constraintStart_toStartOf=\"@+id/idBtnPickTime\" />\n" +
                "\n" +
                "    <Button\n" +
                "        android:id=\"@+id/idBtnPickTime\"\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_centerInParent=\"true\"\n" +
                "        android:layout_margin=\"20dp\"\n" +
                "        android:backgroundTint=\"#005211\"\n" +
                "        android:text=\"Pick Time\"\n" +
                "        android:textAllCaps=\"false\"\n" +
                "        app:layout_constraintBottom_toBottomOf=\"parent\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"parent\"\n" +
                "        app:layout_constraintHorizontal_bias=\"1.0\"\n" +
                "        app:layout_constraintStart_toStartOf=\"parent\"\n" +
                "        app:layout_constraintTop_toTopOf=\"parent\" />\n"+
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
