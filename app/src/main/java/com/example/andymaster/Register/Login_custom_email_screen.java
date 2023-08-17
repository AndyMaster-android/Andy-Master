package com.example.andymaster.Register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.andymaster.Modelclasses.Users;
import com.example.andymaster.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login_custom_email_screen extends AppCompatActivity {
    ImageView back_btn;
    AppCompatButton Login_button;
    FirebaseUser firebaseUser;

    // creating a variable for
    // our Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our
    // Database Reference for Firebase.
    DatabaseReference databaseReference;
    TextInputLayout t1, t2, phone_for;
    TextView forgat_password;
    FirebaseAuth Auth;
    RelativeLayout sigin_progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_custom_email_screen);

        t1 = findViewById(R.id.email__registrion);
        t2 = findViewById(R.id.password__register);
        Login_button = findViewById(R.id.Login_button);
        back_btn = findViewById(R.id.back_btn);
        forgat_password = findViewById(R.id.forgat_password);
        sigin_progress_bar = findViewById(R.id.sigin_progress_bar);

        forgat_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgate_bottom_sheet();
            }
        });

        back_btn.setOnClickListener(v -> finish());

        Auth = FirebaseAuth.getInstance();

    }

    public void Login(View view) {

        String email = t1.getEditText().getText().toString();
        String password = t2.getEditText().getText().toString();
        if (TextUtils.isEmpty(email)) {
            t1.setError("please enter email");
        }
        if (TextUtils.isEmpty(password)) {
            t2.setError("please enter password");
        } else {
            registrationuser(email, password);
        }
    }

    private void registrationuser(String email, String password) {
        sigin_progress_bar.setVisibility(View.VISIBLE);

        Auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(Login_custom_email_screen.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = Auth.getCurrentUser();
                            if (user != null) {
                                DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("users").child(user.getUid());

                                usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        if (dataSnapshot.exists()) {

                                            Users user = new Users();
                                            if (user != null) {
                                                sigin_progress_bar.setVisibility(View.GONE);
                                                // Show the user's email in a Toast or update UI
                                                Toast.makeText(Login_custom_email_screen.this, "Welcome back, " + user.getEmail() + "!", Toast.LENGTH_SHORT).show();
                                                // Example: startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                                            finish();
                                            }
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {
                                        // Handle errors
                                    }
                                });
                            }
                        } else {
                            sigin_progress_bar.setVisibility(View.GONE);
                            // Login failed, show an error message
                            Toast.makeText(Login_custom_email_screen.this, "Login failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }




    private void forgate_bottom_sheet() {
        CardView phone_card, mail_card;

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.BottomSheetDialogTheme);

        // passing a layout file for our bottom sheet dialog.
        View layout = LayoutInflater.from(this).inflate(R.layout.makeselection_bottomsheet, null);

        phone_card = layout.findViewById(R.id.phon_card);
        mail_card = layout.findViewById(R.id.mail_card);

        // passing our layout file to our bottom sheet dialog.
        bottomSheetDialog.setContentView(layout);

        phone_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_custom_email_screen.this, forgat_password_phonno.class));
                bottomSheetDialog.dismiss();
            }
        });

        mail_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_custom_email_screen.this, forget_password_email.class));
                bottomSheetDialog.dismiss();
            }
        });
        // below line is to set our bottom sheet dialog as cancelable.

        // below line is to display our bottom sheet dialog.
        bottomSheetDialog.show();

    }


}