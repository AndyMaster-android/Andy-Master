package com.example.andymaster.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andymaster.Android_Courses.Andoid_Learning_Ac;
import com.example.andymaster.R;
import com.example.andymaster.comman.imageview_slider_Adopter;

public class Home_Fragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public Home_Fragment() {
        // Required empty public constructor
    }

    CardView Android_Card;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewPager mViewPager;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Android_Card = view.findViewById(R.id.android_development_course);
        Android_Card.setOnClickListener(v -> startActivity(new Intent(getContext(), Andoid_Learning_Ac.class)));
        mViewPager = (ViewPager) view.findViewById(R.id.my_pager);
        imageview_slider_Adopter adapterView = new imageview_slider_Adopter(getContext());
        mViewPager.setAdapter(adapterView);
        return view;
    }
}