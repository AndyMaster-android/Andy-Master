package com.example.andymaster.Android_Tetorials.A_Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.andymaster.Adopterclasses.Button_source_code_viewpager_Adopter;
import com.example.andymaster.Adopterclasses.switch_sourcecode_viewpager_adopter;
import com.example.andymaster.R;
import com.google.android.material.tabs.TabLayout;

public class Switch_source_code extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_source_code);
        tabLayout =findViewById(R.id.Tablayout);
        viewPager = findViewById(R.id.view_pager);
        switch_sourcecode_viewpager_adopter Adopter = new switch_sourcecode_viewpager_adopter(getSupportFragmentManager());
        viewPager.setAdapter(Adopter);
        tabLayout.setupWithViewPager(viewPager);

    }
}