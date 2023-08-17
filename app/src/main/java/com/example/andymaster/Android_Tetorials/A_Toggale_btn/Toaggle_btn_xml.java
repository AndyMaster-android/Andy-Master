package com.example.andymaster.Android_Tetorials.A_Toggale_btn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class Toaggle_btn_xml extends Fragment {
    CodeView mCodeView , mcode2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String XML_CODE = "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"match_parent\"\n" +
                "    android:orientation=\"vertical\"\n" +
                "    android:paddingBottom=\"@dimen/activity_vertical_margin\"\n" +
                "    android:paddingLeft=\"@dimen/activity_horizontal_margin\"\n" +
                "    android:paddingRight=\"@dimen/activity_horizontal_margin\"\n" +
                "    android:paddingTop=\"@dimen/activity_vertical_margin\"\n" +
                "    tools:context=\".MainActivity\"> \n" +
                "    <ToggleButton\n" +
                "        android:id=\"@+id/simpleToggleButton1\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_gravity=\"center_horizontal\"\n" +
                "        android:checked=\"false\"\n" +
                "        android:drawablePadding=\"20dp\"\n" +
                "        android:textColor=\"#000\"\n" +
                "        app:layout_constraintBottom_toBottomOf=\"parent\"\n" +
                "        app:layout_constraintEnd_toEndOf=\"parent\"\n" +
                "        app:layout_constraintHorizontal_bias=\"0.498\"\n" +
                "        app:layout_constraintStart_toStartOf=\"parent\"\n" +
                "        app:layout_constraintTop_toTopOf=\"parent\"\n" +
                "        app:layout_constraintVertical_bias=\"0.241\" /> \n"+
                "</LinearLayout";

        // Inflate the layout for this fragment


        View view =inflater.inflate(R.layout.fragment_button__x_m_l, container, false);
        mCodeView = view.findViewById(R.id.codeView);
        GoSyntaxManager.applyMonokaiTheme(getContext(), mCodeView);
        mCodeView.setText(XML_CODE);
        return view;
    }
}
