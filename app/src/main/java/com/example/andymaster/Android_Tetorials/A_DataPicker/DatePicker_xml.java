package com.example.andymaster.Android_Tetorials.A_DataPicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class DatePicker_xml extends Fragment {
    CodeView mCodeView ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String XML_code = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<RelativeLayout\n" +
                "\txmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "\txmlns:tools=\"http://schemas.android.com/tools\"\n" +
                "\tandroid:id=\"@+id/idRLContainer\"\n" +
                "\tandroid:layout_width=\"match_parent\"\n" +
                "\tandroid:layout_height=\"match_parent\"\n" +
                "\tandroid:orientation=\"vertical\"\n" +
                "\ttools:context=\".MainActivity\">\n" +
                "\n" +
                "\t<!--on below line we are creating\n" +
                "\t\ta text for our app-->\n" +
                "\t<TextView\n" +
                "\t\tandroid:id=\"@+id/idTVHeading\"\n" +
                "\t\tandroid:layout_width=\"match_parent\"\n" +
                "\t\tandroid:layout_height=\"wrap_content\"\n" +
                "\t\tandroid:layout_above=\"@id/idTVSelectedDate\"\n" +
                "\t\tandroid:layout_centerInParent=\"true\"\n" +
                "\t\tandroid:layout_margin=\"20dp\"\n" +
                "\t\tandroid:gravity=\"center\"\n" +
                "\t\tandroid:padding=\"10dp\"\n" +
                "\t\tandroid:text=\"Date Picker Dialog in Android\"\n" +
                "\t\tandroid:textAlignment=\"center\"\n" +
                "\t\tandroid:textColor=\"@color/black\"\n" +
                "\t\tandroid:textSize=\"20sp\"\n" +
                "\t\tandroid:textStyle=\"bold\" />\n" +
                "\n" +
                "\t<!--on below line we are creating a text view-->\n" +
                "\t<TextView\n" +
                "\t\tandroid:id=\"@+id/idTVSelectedDate\"\n" +
                "\t\tandroid:layout_width=\"match_parent\"\n" +
                "\t\tandroid:layout_height=\"wrap_content\"\n" +
                "\t\tandroid:layout_above=\"@id/idBtnPickDate\"\n" +
                "\t\tandroid:layout_centerInParent=\"true\"\n" +
                "\t\tandroid:layout_margin=\"20dp\"\n" +
                "\t\tandroid:gravity=\"center\"\n" +
                "\t\tandroid:padding=\"10dp\"\n" +
                "\t\tandroid:text=\"Date\"\n" +
                "\t\tandroid:textAlignment=\"center\"\n" +
                "\t\tandroid:textColor=\"@color/black\"\n" +
                "\t\tandroid:textSize=\"20sp\"\n" +
                "\t\tandroid:textStyle=\"bold\" />\n" +
                "\n" +
                "\t<!--on below line we are creating\n" +
                "\t\ta button for date picker-->\n" +
                "\t<Button\n" +
                "\t\tandroid:id=\"@+id/idBtnPickDate\"\n" +
                "\t\tandroid:layout_width=\"match_parent\"\n" +
                "\t\tandroid:layout_height=\"wrap_content\"\n" +
                "\t\tandroid:layout_centerInParent=\"true\"\n" +
                "\t\tandroid:layout_margin=\"20dp\"\n" +
                "\t\tandroid:text=\"Pick Date\"\n" +
                "\t\tandroid:textAllCaps=\"false\" />\n" +
                "\n" +
                "</RelativeLayout>\n";

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button__x_m_l, container, false);
        mCodeView = view.findViewById(R.id.codeView);
        GoSyntaxManager.applyMonokaiTheme(getContext(), mCodeView);
        mCodeView.setText(XML_code);
        return view;
    }
}
