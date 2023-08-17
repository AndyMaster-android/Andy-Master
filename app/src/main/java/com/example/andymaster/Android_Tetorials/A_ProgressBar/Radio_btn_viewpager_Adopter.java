package com.example.andymaster.Android_Tetorials.A_ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.andymaster.Android_Tetorials.A_EDitText.EditText_XML_code;
import com.example.andymaster.Android_Tetorials.A_EDitText.EditText_java_code;
import com.example.andymaster.Android_Tetorials.A_Radio_btn.Radio_btn_xml;
import com.example.andymaster.Android_Tetorials.A_Radio_btn.Radio_java;

public class Radio_btn_viewpager_Adopter  extends FragmentPagerAdapter {


    public Radio_btn_viewpager_Adopter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new Radio_java();
        }else
            return new Radio_btn_xml();
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return "Java Code";
        }
        else
            return "XML Code";
    }
}

