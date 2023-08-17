package com.example.andymaster.Adopterclasses;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.andymaster.Android_Tetorials.A_btn.Button_XML;
import com.example.andymaster.Android_Tetorials.A_btn.Button_java;
import com.example.andymaster.Modelclasses.child_model_recyclerview;

public class Button_source_code_viewpager_Adopter extends FragmentPagerAdapter {
    public Button_source_code_viewpager_Adopter( FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new Button_java();
        }else
            return new Button_XML();
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
