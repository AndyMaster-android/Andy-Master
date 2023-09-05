package com.example.andymaster.comman;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;

import com.example.andymaster.HelaperClasses.View_pager_Adopter_class;
import com.example.andymaster.R;
import com.example.andymaster.User_Dashboard;

public class onBoarding_screen extends AppCompatActivity {
    int postion = 0;
    int currunt_position = 0;
    Animation Get_start_btn;
    AppCompatButton Skip_btn , get_start_btn ,Next_btn;
    View_pager_Adopter_class view_adopter;
    ViewPager viewPager;
    LinearLayout Dots;
    TextView[] dots;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.onboarding_activity_screen);

        viewPager = findViewById(R.id.view_pager_onBoarding_screen);
        Dots = findViewById(R.id.dots);
        view_adopter = new View_pager_Adopter_class(this);
        get_start_btn = findViewById(R.id.get_strat_btn);
        Skip_btn = findViewById(R.id.Skip_btn);
        Get_start_btn = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        Next_btn =findViewById(R.id.next_btn);

        viewPager.setAdapter(view_adopter);
        add_dots(postion);
        viewPager.addOnPageChangeListener(listener);


    }

    private void add_dots(int postion) {

        dots = new TextView[3];
        Dots.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(25);
            dots[i].setTextColor(Color.BLUE);
            Dots.addView(dots[i]);
        }
        if (dots.length > 0) {
            dots[postion].setTextColor(getResources().getColor(R.color.white));
        }
    }

    ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


        }

        @Override
        public void onPageSelected(int position) {

            currunt_position =position;
            add_dots(position);
            if (position == 0) {
                Skip_btn.setVisibility(View.VISIBLE);
                Next_btn.setVisibility(View.VISIBLE);
                get_start_btn.setVisibility(View.INVISIBLE);
            } else if (position == 1) {
                Skip_btn.setVisibility(View.VISIBLE);
                Next_btn.setVisibility(View.VISIBLE);
                get_start_btn.setVisibility(View.INVISIBLE);

            } else {

                Skip_btn.setVisibility(View.INVISIBLE);
                get_start_btn.setVisibility(View.VISIBLE);
                Next_btn.setVisibility(View.INVISIBLE);
                get_start_btn.setAnimation(Get_start_btn);
            }
        }


        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void Skip(View view) {
        startActivity(new Intent(this, User_Dashboard.class));
        finish();
    }

    public void Next_btn(View view) {
        viewPager.setCurrentItem(currunt_position+1);
    }

    public void GET_START(View view) {
        startActivity(new Intent(this,User_Dashboard.class));
        finish();
    }

    public void back_btn(View view) {
        viewPager.setCurrentItem(currunt_position-1);
    }


}