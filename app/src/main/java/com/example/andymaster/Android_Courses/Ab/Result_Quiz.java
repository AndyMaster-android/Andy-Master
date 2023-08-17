package com.example.andymaster.Android_Courses.Ab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andymaster.Android_Courses.Andoid_Learning_Ac;
import com.example.andymaster.DataBase.SessionManger;
import com.example.andymaster.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Result_Quiz extends AppCompatActivity {

    TextView score,earnedCoins ;
    AppCompatButton restartBtn;
    int POINTS = 10;
    long Score = 0 ;

    FirebaseUser user;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_quiz);
        restartBtn = findViewById(R.id.restartBtn);
        score =findViewById(R.id.score);
        earnedCoins =findViewById(R.id.earnedCoins);
        int correctAnswers = getIntent().getIntExtra("correct", 0);
        int totalQuestions = getIntent().getIntExtra("total", 0);
        Score = correctAnswers * POINTS;
        score.setText(String.format("%d/%d", correctAnswers, totalQuestions));
        earnedCoins.setText(String.valueOf(Score));

        user = FirebaseAuth.getInstance().getCurrentUser();
        SessionManger sessionManger =new SessionManger(Result_Quiz.this , SessionManger.User_Session);

        reference = FirebaseDatabase.getInstance().getReference();/*
        reference.child("Users :").child(user.getUid()).child("User Score : ").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    // Retrieve the existing score
                    int existingScore = snapshot.getValue(Integer.class);

                    // Add the new score to the existing score
                    int updatedScore = (int) (existingScore + Score);

                    // Update the user's score in Firebase
                    snapshot.getRef().setValue(updatedScore);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        */
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Result_Quiz.this , Andoid_Learning_Ac.class));
                finish();
            }
        });
    }
}