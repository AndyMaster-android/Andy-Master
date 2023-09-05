package com.example.andymaster.Register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.andymaster.Modelclasses.Users;
import com.example.andymaster.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Custom_email_Singup_screen extends AppCompatActivity {
    TextInputLayout username, email, password;
    RelativeLayout progressbar;
    DatabaseReference mRootRef;
    FirebaseAuth mAuth;

    ImageView back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custum_email_login_screen);
        back_button = findViewById(R.id.back_button);
        progressbar = findViewById(R.id.signup_progress_bar);
        email = findViewById(R.id.email_registrion);

        password = findViewById(R.id.password_register);
        username = findViewById(R.id.username);
        mRootRef = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        back_button.setOnClickListener(v ->
                finish());

    }

    public void signuphere(View view) {
        int correctAnswers = getIntent().getIntExtra("correct", 0);
        String Email = email.getEditText().getText().toString();
        String Password = password.getEditText().getText().toString();
        String Username = username.getEditText().getText().toString();

        if (TextUtils.isEmpty(Email)) {
            email.setError("please enter email");

        }
        if (TextUtils.isEmpty(Password)) {
            password.setError("please enter password");
        }
        if (TextUtils.isEmpty(Username)) {
            username.setError("please enter username");

        }
        if (Password.length() < 6) {
            password.setHelperText("minimum >=6");

        } else {
            registerUser(Username, Email, Password, correctAnswers);
        }

    }

    private void registerUser(final String username, final String email, final String password, int score) {

        progressbar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {

            @Override
            public void onSuccess(AuthResult authResult) {

                HashMap<String, Object> map = new HashMap<>();
                map.put("email", email);
                map.put("fullname", "Default");
                map.put("username", username);
                map.put("password", password);
                map.put("token", "token");
                map.put("id", mAuth.getCurrentUser().getUid());
                map.put("bio", "");
                map.put("imageurl", "default");

                mRootRef.child("Users").child(mAuth.getCurrentUser().getUid()).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Custom_email_Singup_screen.this, "Update the profile " +
                                    "for better expereince", Toast.LENGTH_SHORT).show();
                            progressbar.setVisibility(View.GONE);
                        }
                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Custom_email_Singup_screen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                progressbar.setVisibility(View.GONE);
            }
        });

    }
}