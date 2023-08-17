package com.example.andymaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.andymaster.Fragment.Community_fragment;
import com.example.andymaster.Fragment.Home_Fragment;

import com.example.andymaster.Fragment.Profile;
import com.example.andymaster.Fragment.SearchFragment;
import com.example.andymaster.Fragment.massage_fragment;
import com.example.andymaster.Fragment.UserProfile.User_Profile_;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class User_Dashboard extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    NavigationView drawer_navi;
    RelativeLayout contentView;
    private static final float END_SCALE = 0.7f;
    ImageView drawer_navi_icon, settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_dash_board);
        settings = findViewById(R.id.settings);
        contentView = findViewById(R.id.contentView);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        drawer_navi_icon = findViewById(R.id.drawer_navi_icon);
        drawerLayout = findViewById(R.id.Drawar_layout);
        drawer_navi = findViewById(R.id.drawar_navi);

        Drawer_navi();
        Animtion_drawer_navi();
        //  Register_screen();
        bottom_navi();

    }

    private void Animtion_drawer_navi() {
        drawerLayout.setScrimColor(getResources().getColor(androidx.cardview.R.color.cardview_light_background));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);
                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        });
    }

    private void Drawer_navi() {

        drawer_navi_icon.setOnClickListener(v -> {
            drawer_navi.bringToFront();
            drawerLayout.openDrawer(Gravity.LEFT);
            drawer_navi.setNavigationItemSelectedListener(item -> {
                switch (item.getItemId()) {
                    case R.id.profile:
                        FirebaseAuth.getInstance().signOut();
                        drawerLayout.closeDrawers();
                        return false;
                    case R.id.Pro:
                        Toast.makeText(this, "You clicked on Pro Subcription", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.progress:
                        Toast.makeText(this, "You clicked on progress", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.rateing:
                        Toast.makeText(this, "You clicked on Rateing", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        return true;
                }
                return false;
            });
        });


    }

    private void bottom_navi() {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home_Fragment()).commit();
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    settings.setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home_Fragment()).commit();
                    return true;
                case R.id.comunity:
                    settings.setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Community_fragment()).commit();
                    return true;
                case R.id.search:
                    settings.setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SearchFragment()).commit();
                    return true;
                case R.id.massage:
                    settings.setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new massage_fragment()).commit();
                    return true;
                case R.id.user_Profile:

                    if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                        settings.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new User_Profile_()).commit();
                        return true;
                    } else {
                        settings.setVisibility(View.GONE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Profile()).commit();

                        return true;
                    }

            }
            return false;
        });

    }
}