package com.example.andymaster.Android_Tetorials.A_Check_Box;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class checkbox_xml  extends Fragment {
    CodeView mCodeView , mcode2;
    GoSyntaxManager goSyntaxManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String XML_code = "\n" +
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>  \n" +
                "<android.support.constraint.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"  \n" +
                "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"  \n" +
                "    xmlns:tools=\"http://schemas.android.com/tools\"  \n" +
                "    android:layout_width=\"match_parent\"  \n" +
                "    android:layout_height=\"match_parent\"  \n" +
                "    tools:context=\"example.Andymaster.com.checkbox.MainActivity\">  \n" +
                "  \n" +
                "  \n" +
                "    <CheckBox  \n" +
                "        android:id=\"@+id/checkBox\"  \n" +
                "        android:layout_width=\"wrap_content\"  \n" +
                "        android:layout_height=\"wrap_content\"  \n" +
                "        android:layout_marginLeft=\"144dp\"  \n" +
                "        android:layout_marginTop=\"68dp\"  \n" +
                "        android:text=\"Pizza\"  \n" +
                "        app:layout_constraintStart_toStartOf=\"parent\"  \n" +
                "        app:layout_constraintTop_toTopOf=\"parent\" />  \n" +
                "  \n" +
                "    <CheckBox  \n" +
                "        android:id=\"@+id/checkBox2\"  \n" +
                "        android:layout_width=\"wrap_content\"  \n" +
                "        android:layout_height=\"wrap_content\"  \n" +
                "        android:layout_marginLeft=\"144dp\"  \n" +
                "        android:layout_marginTop=\"28dp\"  \n" +
                "        android:text=\"Coffee\"  \n" +
                "        app:layout_constraintStart_toStartOf=\"parent\"  \n" +
                "        app:layout_constraintTop_toBottomOf=\"@+id/checkBox\" />  \n" +
                "  \n" +
                "    <CheckBox  \n" +
                "        android:id=\"@+id/checkBox3\"  \n" +
                "        android:layout_width=\"wrap_content\"  \n" +
                "        android:layout_height=\"wrap_content\"  \n" +
                "        android:layout_marginLeft=\"144dp\"  \n" +
                "        android:layout_marginTop=\"28dp\"  \n" +
                "        android:text=\"Burger\"  \n" +
                "        app:layout_constraintStart_toStartOf=\"parent\"  \n" +
                "        app:layout_constraintTop_toBottomOf=\"@+id/checkBox2\" />  \n" +
                "  \n" +
                "    <Button  \n" +
                "        android:id=\"@+id/button\"  \n" +
                "        android:layout_width=\"wrap_content\"  \n" +
                "        android:layout_height=\"wrap_content\"  \n" +
                "        android:layout_marginLeft=\"144dp\"  \n" +
                "        android:layout_marginTop=\"184dp\"  \n" +
                "        android:text=\"Order\"  \n" +
                "        app:layout_constraintStart_toStartOf=\"parent\"  \n" +
                "        app:layout_constraintTop_toBottomOf=\"@+id/checkBox3\" />  \n" +
                "  \n" +
                "</android.support.constraint.ConstraintLayout>";

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button__x_m_l, container, false);
        mCodeView = view.findViewById(R.id.codeView);
        GoSyntaxManager.applyMonokaiTheme(getContext(), mCodeView);
        mCodeView.setText(XML_code);

        return view;
    }
}