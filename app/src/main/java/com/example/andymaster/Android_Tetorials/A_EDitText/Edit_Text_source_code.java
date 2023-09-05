package com.example.andymaster.Android_Tetorials.A_EDitText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.andymaster.Adopterclasses.Button_source_code_viewpager_Adopter;
import com.example.andymaster.Adopterclasses.EditText_source_code_viewpager_Adopter;
import com.example.andymaster.R;
import com.google.android.material.tabs.TabLayout;

public class Edit_Text_source_code extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_source_code);
        tabLayout =findViewById(R.id.Tablayout);
        viewPager = findViewById(R.id.view_pager);
        EditText_source_code_viewpager_Adopter Adopter = new EditText_source_code_viewpager_Adopter(getSupportFragmentManager());
        viewPager.setAdapter(Adopter);
        tabLayout.setupWithViewPager(viewPager);

    }
}