package com.example.andymaster.Fragment.UserProfile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.andymaster.Adopterclasses.UserProfileAdopter.user_profile_adopter;
import com.example.andymaster.Fragment.CumunitySection.Activites.FollowersActivity;
import com.example.andymaster.Fragment.CumunitySection.Activites.OptionsActivity;
import com.example.andymaster.Modelclasses.Post;
import com.example.andymaster.Modelclasses.Users;
import com.example.andymaster.R;
import com.example.andymaster.commuity_Adopter.PhotoAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class User_Profile_ extends Fragment {


    private CircleImageView imageProfile;

    private TextView posts;
    private TextView fullname;
    private TextView bio;
    private TextView username;


    String profileId;

    private RecyclerView recyclerView;
    private PhotoAdapter photoAdapter;
    private List<Post> myPhotoList;
    private ImageView myPictures;
    TabLayout tabLayout;
    ViewPager viewPager;


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user__profile_, container, false);
        tabLayout = view.findViewById(R.id.Tablayout);
        viewPager = view.findViewById(R.id.view_pager);

        imageProfile = view.findViewById(R.id.profile_image);
        //   fullname = view.findViewById(R.id.fullname);
        bio = view.findViewById(R.id.bio);
        username = view.findViewById(R.id.fullname);
        user_profile_adopter adopter = new user_profile_adopter(getChildFragmentManager());
        viewPager.setAdapter(adopter);
        tabLayout.setupWithViewPager(viewPager);
        userInfo();
        return view;
    }

    private void userInfo() {

        FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Users user = dataSnapshot.getValue(Users.class);

                Picasso.get().load(user.getImageurl()).into(imageProfile);
                username.setText(user.getName());

                //  fullname.setText(user.getName());
                bio.setText(user.getBio());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

