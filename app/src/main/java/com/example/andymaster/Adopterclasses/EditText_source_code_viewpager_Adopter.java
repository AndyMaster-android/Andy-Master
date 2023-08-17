package com.example.andymaster.Adopterclasses;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.andymaster.Android_Tetorials.A_EDitText.EditText_XML_code;
import com.example.andymaster.Android_Tetorials.A_EDitText.EditText_java_code;
import com.example.andymaster.Android_Tetorials.A_btn.Button_XML;
import com.example.andymaster.Android_Tetorials.A_btn.Button_java;

public class EditText_source_code_viewpager_Adopter  extends FragmentPagerAdapter {


    public EditText_source_code_viewpager_Adopter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new EditText_java_code();
        }else
            return new EditText_XML_code();
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
