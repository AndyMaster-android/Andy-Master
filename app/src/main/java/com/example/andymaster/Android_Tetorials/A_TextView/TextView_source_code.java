package com.example.andymaster.Android_Tetorials.A_TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.andymaster.Adopterclasses.Button_source_code_viewpager_Adopter;
import com.example.andymaster.Adopterclasses.Textview_sourcecode_viewpager;
import com.example.andymaster.R;
import com.google.android.material.tabs.TabLayout;

public class TextView_source_code extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_source_code);

        tabLayout = findViewById(R.id.Tablayout);
        viewPager = findViewById(R.id.view_pager);
        Textview_sourcecode_viewpager Adopter = new Textview_sourcecode_viewpager(getSupportFragmentManager());
        viewPager.setAdapter(Adopter);
        tabLayout.setupWithViewPager(viewPager);

    }
}