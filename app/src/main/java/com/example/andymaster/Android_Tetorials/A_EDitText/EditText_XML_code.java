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

        String XML_code = "\n" +
                "                <RelativeLayout  xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "                    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                "                    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                "                    android:id=\"@+id/activity_main\"\n" +
                "                    android:layout_width=\"match_parent\"\n" +
                "                    android:layout_height=\"match_parent\"\n" +
                "                    tools:context=\".Android_Tetorials.A_EDitText.EditText\">\n" +
                "\n" +
                "                    <EditText\n" +
                "                        android:id=\"@+id/editText1\"\n" +
                "                        android:layout_width=\"wrap_content\"\n" +
                "                        android:layout_height=\"wrap_content\"/>  <Button   \\s\n" +
                "                        android:id=\"@+id/button\"   \\s\n" +
                "                        android:layout_width=\"wrap_content\"   \\s\n" +
                "                        android:layout_height=\"wrap_content\"   \\s\n" +
                "                        android:layout_below=\"@+id/editText2\"   \\s\n" +
                "                        android:layout_centerHorizontal=\"true\"   \\s\n" +
                "                        android:layout_marginTop=\"109dp\"   \\s\n" +
                "                        android:text=\"Show Value\"   \\s\n" +
                "                        tools:layout_editor_absoluteX=\"148dp\"   \\s\n" +
                "                        tools:layout_editor_absoluteY=\"266dp\" />\n" +
                "                </RelativeLayout>";

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button__x_m_l, container, false);
        mCodeView = view.findViewById(R.id.codeView);
        GoSyntaxManager.applyMonokaiTheme(getContext(), mCodeView);
        mCodeView.setText(XML_code);
        return view;
    }
}
