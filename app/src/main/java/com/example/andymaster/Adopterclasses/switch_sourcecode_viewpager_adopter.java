package com.example.andymaster.Adopterclasses;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.andymaster.Android_Tetorials.A_Switch.Switch_java;
import com.example.andymaster.Android_Tetorials.A_Switch.switch_xml;

public class switch_sourcecode_viewpager_adopter extends FragmentPagerAdapter {


    public switch_sourcecode_viewpager_adopter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new Switch_java();
        }else
            return new switch_xml();
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
