package com.example.andymaster.Android_Courses.Ab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.andymaster.HelaperClasses.View_pager_Adopter_class;
import com.example.andymaster.R;
import com.example.andymaster.User_Dashboard;

import java.util.ArrayList;
import java.util.List;

public class intro_Android_Activity extends AppCompatActivity {
    int postion = 0;
    int currunt_position = 0;


    Animation Get_start_btn;
    AppCompatButton get_start_btn;

    ViewPager viewPager;

    private  int st = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_android2);


       // viewPager = findViewById(R.id.view_pager);

        String[] initialContents = {"Page 1 Content", "Page 2 Content", "Page 3 Content"};

        get_start_btn = findViewById(R.id.get_strat_btn);

        Get_start_btn = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        // Create tutorial pages
        List<TutorialPage> tutorialPages = new ArrayList<>();
        tutorialPages.add(new TutorialPage(R.drawable.application, "Page 1 content", 25));
        tutorialPages.add(new TutorialPage(R.drawable.download__2_, "Page 2 content", 50));
        tutorialPages.add(new TutorialPage(R.drawable.download__3_, "Page 3 content", 75));


        // Set up ViewPager
         viewPager = findViewById(R.id.pager);

        PagerAdopter adapter = new PagerAdopter(this, tutorialPages);
        viewPager.setAdapter(adapter);
         final int  current = tutorialPages.size();
        get_start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    if (st < tutorialPages.size()) {
                        viewPager.setCurrentItem(st, true);
                        st++;
                        if (st == current) {
                            get_start_btn.setText("Start MCQS");
                            get_start_btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(getApplicationContext(), intro_Quiz.class));
                                    finish();
                                }
                            });


                        }

                    }
            }
        });


        }

        }





