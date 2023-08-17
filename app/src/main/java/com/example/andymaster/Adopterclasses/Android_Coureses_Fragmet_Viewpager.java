package com.example.andymaster.Adopterclasses;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.andymaster.Android_Tetorials.Android_Tutorial;
import com.example.andymaster.Android_Courses.A.Learning_Fragment;

public class Android_Coureses_Fragmet_Viewpager extends FragmentPagerAdapter {

    public Android_Coureses_Fragmet_Viewpager( FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new Learning_Fragment();
        }else

            return new Android_Tutorial();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            String Android = "Android Learn";

            return Android;
        }
        else
            return "Android Tutorial";
    }
}
