package com.example.andymaster.comman;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.andymaster.R;
import com.example.andymaster.User_Dashboard;

public class SplashScreen extends AppCompatActivity {

    View first_line, second_line, third_line, fourth_line, five_line, six_line, seventh_line, eight_line;
    TextView Tagline;
    ImageView logo;
    Animation left_animation, right_animation, middle_animation, bottom_animation;


    SharedPreferences Sharedprefernce_onBoadingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //Animation  attached
        left_animation = AnimationUtils.loadAnimation(this, R.anim.left_animation);
        right_animation = AnimationUtils.loadAnimation(this, R.anim.right_anmation);
        middle_animation = AnimationUtils.loadAnimation(this, R.anim.middle_animation);
        bottom_animation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);


        //load oon UI element
        first_line = findViewById(R.id.first_line);
        second_line = findViewById(R.id.secand_line);
        third_line = findViewById(R.id.third_line);
        fourth_line = findViewById(R.id.fourth_line);
        five_line = findViewById(R.id.first_line_);
        six_line = findViewById(R.id.secand_line_);
        seventh_line = findViewById(R.id.third_line_);
        eight_line = findViewById(R.id.fourth_line_);

        //left Animation
        first_line.setAnimation(left_animation);
        second_line.setAnimation(left_animation);
        third_line.setAnimation(left_animation);
        fourth_line.setAnimation(left_animation);

        //Right Animation
        five_line.setAnimation(right_animation);
        six_line.setAnimation(right_animation);
        seventh_line.setAnimation(right_animation);
        eight_line.setAnimation(right_animation);

        //logo Animation
        logo = findViewById(R.id.logo);
        logo.setAnimation(middle_animation);

        //Tagline Animation
        Tagline = findViewById(R.id.develpoer_name);
        Tagline.setAnimation(bottom_animation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences boarding_preferences = getSharedPreferences("boarding", MODE_PRIVATE);
                boolean check_boarding = boarding_preferences.getBoolean("first_Time",true);

                if (check_boarding){
                    SharedPreferences.Editor editor = boarding_preferences.edit();
                    editor.putBoolean("first_Time", false);
                    editor.apply();
                    Intent boarding_screen = new Intent(getApplicationContext(), onBoarding_screen.class);
                    startActivity(boarding_screen);
                    finish();
                }
                else {
                    Intent Dashboarding_screen = new Intent(getApplicationContext(), User_Dashboard.class);
                    startActivity(Dashboarding_screen);
                    finish();
                }


            }
        }, 5000);

    }
}