package com.example.andymaster.Register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.andymaster.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class forget_password_email extends AppCompatActivity {
    AppCompatButton Forget_btn;
    TextInputLayout email_forget;
    FirebaseAuth mAuth;
    ImageView forgot_password_back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_email);
        Forget_btn = findViewById(R.id.Forget_btn);
        email_forget = findViewById(R.id.email_forget);
        mAuth = FirebaseAuth.getInstance();
        forgot_password_back_btn = findViewById(R.id.forgot_password_back_btn);
        forgot_password_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void Forget_btn(View view) {
        String Email = email_forget.getEditText().getText().toString();
        if (TextUtils.isEmpty(Email)) {
            email_forget.setError("please enter register email id");
        }else {

            mAuth.sendPasswordResetEmail(Email)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(forget_password_email.this, Login_custom_email_screen.class));
                            finish();
                        }

                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    });

        }
    }
}