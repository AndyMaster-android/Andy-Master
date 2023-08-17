package com.example.andymaster.Adopterclasses;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.andymaster.Android_Tetorials.A_RatingBar.RatingBar_java;
import com.example.andymaster.Android_Tetorials.A_RatingBar.RatingBar_xml;
import com.example.andymaster.Android_Tetorials.A_TextView.TextView_Java;
import com.example.andymaster.Android_Tetorials.A_TextView.TextView_xml;

public class RatingBar_viewpager_Adopter extends FragmentPagerAdapter {

    public RatingBar_viewpager_Adopter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new RatingBar_java();
        }else
            return new RatingBar_xml();
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
