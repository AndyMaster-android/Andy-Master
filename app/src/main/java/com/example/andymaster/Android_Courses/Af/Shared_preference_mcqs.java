package com.example.andymaster.Android_Courses.Af;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.andymaster.Modelclasses.Quiz_Model;
import com.example.andymaster.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class Shared_preference_mcqs extends AppCompatActivity {
    private ArrayList<Quiz_Model> quizQuestions;
    private int currentQuestionIndex = 0;
    private BottomSheetBehavior bottomSheetBehavior;
    private int score = 0;

    private TextView Question;
    private CountDownTimer timer;
    private AppCompatButton option1, option2, option3, option4, check_btn;
    private ImageView back_btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_quiz);
        Question = findViewById(R.id.Question);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        check_btn = findViewById(R.id.Check);

        bg_btn();

        quizQuestions = new ArrayList<>();
        quizQuestions.add(new Quiz_Model("You experience in android development ? ", "bignear", "intermediate", "Advanced", "Expert", "Expert"));
        quizQuestions.add(new Quiz_Model("Why you want to learn Android Development ? ", "Just Fun", "For Job", "Professionally", "Project", "Professionally"));
        quizQuestions.add(new Quiz_Model("Why you want to learn Android Development ? ", "Just Fun", "For Job", "Professionally", "Project", "Professionally"));
        quizQuestions.add(new Quiz_Model("Why you want to learn Android Development ? ", "Just Fun", "For Job", "Professionally", "Project", "Professionally"));

        check_btn.setEnabled(false);

        displayQuestion();

        option1.setOnClickListener(v -> {
            String selectedOption = option1.getText().toString();
            checkAnswer(option1, selectedOption);
        });
        option2.setOnClickListener(v -> {
            String selectedOption = option2.getText().toString();

            checkAnswer(option2, selectedOption);
        });
        option3.setOnClickListener(v -> {
            String selectedOption = option3.getText().toString();

            checkAnswer(option3, selectedOption);
        });
        option4.setOnClickListener(v -> {
            String selectedOption = option4.getText().toString();

            checkAnswer(option4, selectedOption);
        });

        check_btn.setOnClickListener(v -> goToNextQuestion());

        back_btn = findViewById(R.id.back_btn);
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_cancel);
        dialog.setCancelable(false);
        back_btn.setOnClickListener(v -> {
            Button Quit_btn = dialog.findViewById(R.id.btn_yes);
            Button Keep_learning_btn = dialog.findViewById(R.id.btn_no);
            Quit_btn.setOnClickListener(v1 -> {
                dialog.dismiss();
                finish();
            });
            Keep_learning_btn.setOnClickListener(v12 -> dialog.dismiss());
            dialog.show();
        });
    }
    private void checkAnswer(AppCompatButton button, String selected_Option) {
        Quiz_Model currentQuestion = quizQuestions.get(currentQuestionIndex);
        String answerOptions = currentQuestion.getCorrect_option();
        check_btn.setEnabled(true);
        check_btn.setBackgroundResource(R.drawable.corrrect_option_btn);
        check_btn.setAlpha(1);
        if (selected_Option.equals(answerOptions)) {
            score++;

        }
        if (selected_Option.equals(answerOptions)) {
            button.setBackgroundResource(R.drawable.corrrect_option_btn);

        } else {
            button.setBackgroundResource(R.drawable.wrong_selection_btn);
            disableOptionButtons();
            showWrongAnswerBottomSheet();
        }

        // Disable all option buttons to prevent further selection
    }

    private void disableOptionButtons() {
        option1.setEnabled(false);
        option2.setEnabled(false);
        option3.setEnabled(false);
        option4.setEnabled(false);
    }

    private void bg_btn() {

    }

    private void displayQuestion() {

        Quiz_Model currentQuestion = quizQuestions.get(currentQuestionIndex);
        Question.setText(currentQuestion.getQuestion());
        option1.setText(currentQuestion.getOption1());
        option2.setText(currentQuestion.getOption2());
        option3.setText(currentQuestion.getOption3());
        option4.setText(currentQuestion.getOption4());
    }

    private void goToNextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < quizQuestions.size()) {
            // Reset button background colors
            resetButtonBackgroundColors();

            // Enable all option buttons
            enableOptionButtons();

            // Display the next question
            displayQuestion();
        } else {
            // Quiz completed, show the final score
            Toast.makeText(this, "Quiz completed! Your score is " + score, Toast.LENGTH_SHORT).show();
        }
    }

    private void resetButtonBackgroundColors() {
        option1.setBackgroundResource(R.drawable.quiz_btn);
        option2.setBackgroundResource(R.drawable.quiz_btn);
        option3.setBackgroundResource(R.drawable.quiz_btn);
        option4.setBackgroundResource(R.drawable.quiz_btn);
    }

    private void enableOptionButtons() {
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);
    }

    private void BottomSheet() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottomsheet_quiz);
        bottomSheetDialog.setCancelable(true);
        TextView cancel = bottomSheetDialog.findViewById(R.id.cancel_btn);
        assert cancel != null;
        enableOptionButtons();
        cancel.setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
        });
        bottomSheetDialog.show();
    }
    private void showWrongAnswerBottomSheet() {
        // Inflate the layout for the bottom sheet
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottomsheet_quiz, null);

        // Find the LottieAnimationView in the bottom sheet layout
        LottieAnimationView wrongAnimationView = bottomSheetView.findViewById(R.id.wrongAnimationView);

        // Set up the Lottie animation

        wrongAnimationView.playAnimation();
        // Create the bottom sheet dialog
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(bottomSheetView);

        // Set up the bottom sheet behavior
        bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());

        // Show the bottom sheet
        bottomSheetDialog.show();
    }
}