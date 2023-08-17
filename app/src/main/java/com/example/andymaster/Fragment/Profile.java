package com.example.andymaster.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.andymaster.R;
import com.example.andymaster.Register.Custom_email_Singup_screen;
import com.example.andymaster.Register.Login_custom_email_screen;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class Profile extends Fragment {
    TextView register_btn, Login_btn, intro_motive, textView4;
    Animation left, right, top;
    AppCompatButton Email_btn;
    RelativeLayout login_progress_bar;

    FirebaseAuth Auth;
    DatabaseReference databaseReference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public Profile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        register_btn = view.findViewById(R.id.register_btn);
        Login_btn = view.findViewById(R.id.Login_btn);
        intro_motive = view.findViewById(R.id.text_motive);


        left = AnimationUtils.loadAnimation(getContext(), R.anim.left_animation);
        right = AnimationUtils.loadAnimation(getContext(), R.anim.right_anmation);
        top = AnimationUtils.loadAnimation(getContext(), R.anim.middle_animation);

        intro_motive.setAnimation(top);
        register_btn.setAnimation(right);
        Login_btn.setAnimation(left);
        Login_btn.setOnClickListener(v -> login_bottom_sheet());
        register_btn.setOnClickListener(v -> signup_bottom_sheet());
        return view;
    }

    private void signup_bottom_sheet() {
        TextInputLayout username, email, password;
        AppCompatButton Email_btn;
        ImageView back_btn;

        TextView  googl_login_btn, facebook_login_btn;


        BottomSheetBehavior<View> bottomSheetBehavior;
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireActivity());
        View bottomSheetView = getLayoutInflater().inflate(R.layout.signup_user_screen_bottomsheet, null);
        Email_btn = bottomSheetView.findViewById(R.id.Email_btn);
        back_btn = bottomSheetView.findViewById(R.id.back_btn);
        textView4 = bottomSheetView.findViewById(R.id.textView4);
        googl_login_btn = bottomSheetView.findViewById(R.id.googl_login_btn);
        facebook_login_btn = bottomSheetView.findViewById(R.id.facebook_login_btn);




        bottomSheetDialog.setContentView(bottomSheetView);

        // Set up the bottom sheet behavior
        bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        bottomSheetDialog.hide();

        Email_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getContext() , Custom_email_Singup_screen.class));
                bottomSheetDialog.dismiss();
            }
        });


        // Show the bottom sheet
        bottomSheetDialog.show();
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
            }
        });


    }



    private void login_bottom_sheet() {


        BottomSheetBehavior<View> bottomSheetBehavior;
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireActivity());
        ImageView back_btn;
        View bottomSheetView = getLayoutInflater().inflate(R.layout.login_user_bottomsheet, null);
        back_btn = bottomSheetView.findViewById(R.id.back_btn);
        textView4 = bottomSheetView.findViewById(R.id.textView4);
        Email_btn = bottomSheetView.findViewById(R.id.Email_btn);


        bottomSheetDialog.setContentView(bottomSheetView);

        // Set up the bottom sheet behavior
        bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        Email_btn.setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
            startActivity(new Intent(getContext(), Login_custom_email_screen.class));
        });

        // Show the bottom sheet
        bottomSheetDialog.show();

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
            }
        });


    }
}
