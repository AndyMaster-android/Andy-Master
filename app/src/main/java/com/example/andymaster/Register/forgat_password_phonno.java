package com.example.andymaster.Register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.andymaster.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;

import java.util.concurrent.TimeUnit;

public class forgat_password_phonno extends AppCompatActivity {

    CountryCodePicker codePicker;
    AppCompatButton Send_otp;
    TextInputLayout phone_for;

    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgat_password_phone_no);
        Send_otp = findViewById(R.id.Send_otp);
        codePicker = findViewById(R.id.country_code);
        phone_for = findViewById(R.id.phone_for);


        String getUserEnteredPhoneNumber = phone_for.getEditText().getText().toString();
        String country = codePicker.getFullNumber();
        final String phoneNo = "+" + country + getUserEnteredPhoneNumber;

        Send_otp.setOnClickListener(v -> {

        });

//Remove first zero if entered!

//Complete phone number





        //Animation Hook
        animation = AnimationUtils.loadAnimation(this, R.anim.animation);
//Set animation to all the elements
      /*  screenIcon.setAnimation(animation);
        title.setAnimation(animation);
        description.setAnimation(animation);
        phoneNumberTextField.setAnimation(animation);
        countryCodePicker.setAnimation(animation);
        nextBtn.setAnimation(animation); */
    }



}