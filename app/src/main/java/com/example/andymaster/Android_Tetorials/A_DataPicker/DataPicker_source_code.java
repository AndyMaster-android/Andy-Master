package com.example.andymaster.Android_Tetorials.A_DataPicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.andymaster.Adopterclasses.DatePicker_viewpager_Adopter;
import com.example.andymaster.Adopterclasses.Timepicker_Viewpager_Adopter;
import com.example.andymaster.R;
import com.google.android.material.tabs.TabLayout;

public class DataPicker_source_code extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_source_code);
        tabLayout = findViewById(R.id.Tablayout);
        viewPager = findViewById(R.id.view_pager);
        DatePicker_viewpager_Adopter Adopter = new DatePicker_viewpager_Adopter(getSupportFragmentManager());
        viewPager.setAdapter(Adopter);
        tabLayout.setupWithViewPager(viewPager);

    }
}