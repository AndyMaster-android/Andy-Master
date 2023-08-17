package com.example.andymaster.Android_Tetorials.A_EDitText;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class EditText_XML_code  extends Fragment {
    CodeView mCodeView ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String XML_code = """
                <RelativeLayout  xmlns:android="http://schemas.android.com/apk/res/android"
                    xmlns:app="http://schemas.android.com/apk/res-auto"
                    xmlns:tools="http://schemas.android.com/tools"
                    android:id="@+id/activity_main"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    tools:context=".Android_Tetorials.A_EDitText.EditText">

                    <EditText
                        android:id="@+id/editText1"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"/>  <Button   \s
                        android:id="@+id/button"   \s
                        android:layout_width="wrap_content"   \s
                        android:layout_height="wrap_content"   \s
                        android:layout_below="@+id/editText2"   \s
                        android:layout_centerHorizontal="true"   \s
                        android:layout_marginTop="109dp"   \s
                        android:text="Show Value"   \s
                        tools:layout_editor_absoluteX="148dp"   \s
                        tools:layout_editor_absoluteY="266dp" />
                </RelativeLayout>""";

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button__x_m_l, container, false);
        mCodeView = view.findViewById(R.id.codeView);
        GoSyntaxManager.applyMonokaiTheme(getContext(), mCodeView);
        mCodeView.setText(XML_code);
        return view;
    }
}
