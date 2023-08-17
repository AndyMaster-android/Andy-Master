package com.example.andymaster.Adopterclasses;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.andymaster.Android_Tetorials.A_SeekBar.SeekBar_java;
import com.example.andymaster.Android_Tetorials.A_SeekBar.SeekBar_xml;
import com.example.andymaster.Android_Tetorials.A_webView.WebView_java;
import com.example.andymaster.Android_Tetorials.A_webView.WebView_xml;

public class WebView_ViewPager_Adopter extends FragmentPagerAdapter {

    public WebView_ViewPager_Adopter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new WebView_java();
        }else
            return new WebView_xml();
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
