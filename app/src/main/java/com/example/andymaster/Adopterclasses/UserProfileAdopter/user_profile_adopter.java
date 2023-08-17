package com.example.andymaster.Adopterclasses.UserProfileAdopter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.andymaster.Android_Tetorials.A_AlertDialog.AlertDialog_java;
import com.example.andymaster.Android_Tetorials.A_AlertDialog.AlertDialog_xml;
import com.example.andymaster.Fragment.UserProfile.AchivementFragment;
import com.example.andymaster.Fragment.UserProfile.StatusFragment;

public class user_profile_adopter extends FragmentPagerAdapter {

    public user_profile_adopter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new StatusFragment();
        }else
            return new AchivementFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return "Status";
        }
        else
            return "Achievement";
    }
}
