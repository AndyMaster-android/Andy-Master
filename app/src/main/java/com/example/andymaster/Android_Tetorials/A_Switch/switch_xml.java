package com.example.andymaster.Android_Tetorials.A_Switch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class switch_xml extends Fragment {
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
                "    tools:context=\".AndyMaster.A_Switch.Switch_btn_output\">\n" +
                "\n" +
                "    <androidx.appcompat.widget.SwitchCompat\n" +
                "        android:id=\"@+id/switch_btn\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_marginTop=\"328dp\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"parent\"\n" +
                "        app:layout_constraintHorizontal_bias=\"0.534\"\n" +
                "        app:layout_constraintStart_toStartOf=\"parent\"\n" +
                "        android:onClick=\"onSwitchclick\"\n" +
                "        app:layout_constraintTop_toTopOf=\"parent\"/>\n" +
                "\n" +
                "    <TextView\n" +
                "        android:id=\"@+id/text1\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_marginBottom=\"56dp\"\n" +
                "        android:text=\"Switch is OFF\"\n" +
                "        android:textStyle=\"bold\"\n" +
                "        app:layout_constraintBottom_toTopOf=\"@+id/switch_btn\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"@+id/switch_btn\"\n" +
                "        app:layout_constraintStart_toStartOf=\"@+id/switch_btn\" /> \n" +
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
