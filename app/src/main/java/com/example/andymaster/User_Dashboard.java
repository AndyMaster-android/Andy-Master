package com.example.andymaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andymaster.DataBase.DatabaseRepository;
import com.example.andymaster.Fragment.ChatTabFragment;
import com.example.andymaster.Fragment.Community_fragment;
import com.example.andymaster.Fragment.CumunitySection.Activites.NotificationFragment;
import com.example.andymaster.Fragment.CumunitySection.Activites.PostActivity;
import com.example.andymaster.Fragment.CumunitySection.Status.ShowsMyStatusActivity;
import com.example.andymaster.Fragment.Home_Fragment;

import com.example.andymaster.Fragment.Profile;
import com.example.andymaster.Fragment.SearchFragment;
import com.example.andymaster.Fragment.UserProfile.User_Profile_;
import com.example.andymaster.Fragment.ChatsSection.ContectsActivity;
import com.example.andymaster.Modelclasses.Users;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;

public class User_Dashboard extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    NavigationView drawer_navi;
    RelativeLayout contentView;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    private static final float END_SCALE = 0.7f;
    ImageView drawer_navi_icon, notification, notification_close ;
    private FloatingActionButton mFab, fab_status, fab_post;
    LinearLayout layoutExpandedOptions;

    private boolean isExpanded = false;
    Users user;

    public static final String DATABASE_NAME = "andy_master_db";
    public static final String LOGGED_IN_USER_TABLE = "LOGGED_IN_USER_TABLE";
    public static final String USERS_TABLE = "USERS_TABLE";
    public static final String MESSAGES_TABLE = "MESSAGES_TABLE";
    public static final String BASE_URL = "https://andy-master-default-rtdb.firebaseio.com/";
    DatabaseRepository databaseRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_dash_board);

        contentView = findViewById(R.id.contentView);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        drawer_navi_icon = findViewById(R.id.drawer_navi_icon);
        drawerLayout = findViewById(R.id.Drawar_layout);
        drawer_navi = findViewById(R.id.drawar_navi);

        notification = findViewById(R.id.notification);

        notification_close = findViewById(R.id.notification_close);
        mFab = findViewById(R.id.fab_main);




        Drawer_navi();
        Animtion_drawer_navi();
        //  Register_screen();
        bottom_navi();
        databaseRepository = new DatabaseRepository(this);



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

            View headerview = drawer_navi.getHeaderView(0);
            TextView name = headerview.findViewById(R.id.username);
            name.setText("Imran khan");
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
                    case R.id.Notification:
                        startActivity(new Intent(getApplicationContext(), NotificationFragment.class));
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
        mFab.setVisibility(View.GONE);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home_Fragment()).commit();
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    notification.setVisibility(View.GONE);
                    mFab.setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home_Fragment()).commit();
                    return true;
                case R.id.comunity:
                    notification.setVisibility(View.VISIBLE);
                    mFab.setVisibility(View.VISIBLE);
                    mFab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(User_Dashboard.this, PostActivity.class));
                        }
                    });
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Community_fragment()).commit();
                    return true;
                case R.id.search:
                    mFab.setVisibility(View.GONE);
                    notification.setOnClickListener(view -> {
                        notification.setVisibility(View.GONE);
                        notification_close.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NotificationFragment()).commit();
                        notification_close.setOnClickListener(view1 -> {
                            notification_close.setVisibility(View.GONE);
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Community_fragment()).commit();
                        });
                    });
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SearchFragment()).commit();
                    return true;
                case R.id.massage:
                    mFab.setVisibility(View.VISIBLE);
                    new MaterialShowcaseView.Builder(this)
                            .setTarget(mFab)
                            .setDismissText("GOT IT").setDismissTextColor(R.color.colorBlue)
                            .setContentText("This is some amazing feature you should know about")
                            .setDelay(500) // optional but starting animations immediately in onCreate can make them choppy
                            .singleUse("Got") // provide a unique ID used to ensure it is only shown once
                            .show();
                    mFab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(User_Dashboard.this, ContectsActivity.class));
                        }
                    });
                    notification.setOnClickListener(view -> {
                        notification.setVisibility(View.GONE);
                        notification_close.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NotificationFragment()).commit();
                        notification_close.setOnClickListener(view1 -> {
                            notification_close.setVisibility(View.GONE);
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChatTabFragment()).commit();
                        });
                    });
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChatTabFragment()).commit();
                    return true;
                case R.id.user_Profile:
                    mFab.setVisibility(View.GONE);
                    notification.setOnClickListener(view -> {
                        notification.setVisibility(View.GONE);
                        notification_close.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NotificationFragment()).commit();
                        notification_close.setOnClickListener(view1 -> {
                            notification_close.setVisibility(View.GONE);
                            mFab.setVisibility(View.GONE);
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new User_Profile_()).commit();
                        });
                    });
                    if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                        mFab.setVisibility(View.GONE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new User_Profile_()).commit();
                        return true;
                    } else {
                        mFab.setVisibility(View.GONE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Profile()).commit();
                        return true;
                    }
            }
            return false;
        });
        Bundle intent = getIntent().getExtras();
        if (intent != null) {
            String profileId = intent.getString("publisherId");
            getSharedPreferences("PROFILE", MODE_PRIVATE).edit().putString("profileId", profileId).apply();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new User_Profile_()).commit();
            bottomNavigationView.setSelectedItemId(R.id.user_Profile);
        } else {
            // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new Community_fragment()).commit();
        }
    }

    private void expandOptions(View view) {
        view.setVisibility(View.VISIBLE);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleX, scaleY);
        set.setInterpolator(new DecelerateInterpolator());
        set.setDuration(300);
        set.start();
        mFab.setImageResource(omari.hamza.storyview.R.drawable.ic_close);
        isExpanded = true;
    }
    private void collapseOptions(View view) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleX, scaleY);
        set.setInterpolator(new AccelerateInterpolator());
        set.setDuration(300);
        set.start();
        mFab.setImageResource(R.drawable.baseline_add_24);
        isExpanded = false;
    }
/*
    @Override
    protected void onResume() {
        super.onResume();
        String currentId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        database.getReference().child("presence").child(currentId).setValue("Online");
    }

    @Override
    protected void onPause() {
        super.onPause();
        String currentId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        database.getReference().child("presence").child(currentId).setValue("Offline");
    }

 */
}