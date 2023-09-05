package com.example.andymaster.Android_Courses;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.andymaster.Adopterclasses.Android_Coureses_Fragmet_Viewpager;
import com.example.andymaster.Android_Courses.Download_Code;
import com.example.andymaster.Android_Courses.Get_App_Code;
import com.example.andymaster.R;
import com.example.andymaster.comman.imageview_slider_Adopter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

public class Andoid_Learning_Ac extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    BottomNavigationView Bottom_Navi;
    FrameLayout Framlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andoid_learning);
        tabLayout =findViewById(R.id.Tablayout);
        viewPager = findViewById(R.id.view_pager);
        Bottom_Navi = findViewById(R.id.Android_bott_NavigationView);
        Framlayout = findViewById(R.id.Container);
        Android_Coureses_Fragmet_Viewpager Adopter = new Android_Coureses_Fragmet_Viewpager(getSupportFragmentManager());
        viewPager.setAdapter(Adopter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.color_white)));
        TAbLayout();

        Bottom_Navi();



    }
    private void TAbLayout(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    private void Bottom_Navi() {
        Bottom_Navi.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Android_Studio:
                        tabLayout.setVisibility(View.VISIBLE);
                        viewPager.setVisibility(View.VISIBLE);
                        Framlayout.setVisibility(View.GONE);
                        return true;
                    case R.id.Download:
                        getSupportFragmentManager().beginTransaction().replace(R.id.Container, new Download_Code()).commit();
                        Framlayout.setVisibility(View.VISIBLE);
                        viewPager.setVisibility(View.GONE);
                        tabLayout.setVisibility(View.GONE);
                        return true;
                    case R.id.Get_App:
                        getSupportFragmentManager().beginTransaction().replace(R.id.Container, new Get_App_Code()).commit();
                        Framlayout.setVisibility(View.VISIBLE);
                        viewPager.setVisibility(View.GONE);
                        tabLayout.setVisibility(View.GONE);
                        return true;

                }
                return false;
            }
        });
    }
}