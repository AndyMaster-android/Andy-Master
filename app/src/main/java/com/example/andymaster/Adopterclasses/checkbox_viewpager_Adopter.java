package com.example.andymaster.Adopterclasses;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.andymaster.Android_Tetorials.A_Check_Box.checkbox_java;
import com.example.andymaster.Android_Tetorials.A_Check_Box.checkbox_xml;
import com.example.andymaster.Android_Tetorials.A_EDitText.EditText_XML_code;
import com.example.andymaster.Android_Tetorials.A_EDitText.EditText_java_code;

public class checkbox_viewpager_Adopter extends FragmentPagerAdapter {


    public checkbox_viewpager_Adopter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new checkbox_java();
        }else
            return new checkbox_xml();
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
