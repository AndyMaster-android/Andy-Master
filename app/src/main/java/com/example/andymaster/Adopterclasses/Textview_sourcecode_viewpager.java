package com.example.andymaster.Adopterclasses;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.andymaster.Android_Tetorials.A_TextView.TextView_Java;
import com.example.andymaster.Android_Tetorials.A_TextView.TextView_xml;

public class Textview_sourcecode_viewpager extends FragmentPagerAdapter {

    public Textview_sourcecode_viewpager(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new TextView_Java();
        }else
            return new TextView_xml();
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
