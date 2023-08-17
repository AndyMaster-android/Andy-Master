package com.example.andymaster.Adopterclasses;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.andymaster.Android_Tetorials.A_ProgressBar.ProgressBar_java;
import com.example.andymaster.Android_Tetorials.A_ProgressBar.ProgressBar_xml;

public class ProgressBar_viewpager_Adopter  extends FragmentPagerAdapter {


    public ProgressBar_viewpager_Adopter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new ProgressBar_java();
        }else
            return new ProgressBar_xml();
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
