package com.example.andymaster.Android_Courses.Ab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
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

public class intro_Quiz extends AppCompatActivity {
    ArrayList<Quiz_Model> quizQuestions;
    private int currentQuestionIndex = 0;
    private BottomSheetBehavior bottomSheetBehavior;
    private int score = 0;

    TextView Question, QuestionList, Timertext;

    CountDownTimer timer;
    AppCompatButton option1, option2, option3, option4, check_btn;
    private ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_quiz);
        Timertext = findViewById(R.id.Timertext);
        QuestionList = findViewById(R.id.Questionlist);
        Question = findViewById(R.id.Question);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        check_btn = findViewById(R.id.Check);


        resetTimer();

        ListMCQS();
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

    private void ListMCQS() {
        quizQuestions = new ArrayList<>();
        quizQuestions.add(new Quiz_Model("Q1. Android is an ? ", "Application", "Software", "Operating System", "Smartphone", "Operating System"));
        quizQuestions.add(new Quiz_Model("Q2. Who Invented Android ? ", "James Gosling", "Google", "Andy Robin", "Larry Page", "Andy Robin"));
        quizQuestions.add(new Quiz_Model("Q3. Which Language is Used to Build Android Apps in Android Studio ? ", "Java", "Dart", "Kotlin", "All of These", "All of These"));
        quizQuestions.add(new Quiz_Model("Q4. Which Language is Preferred by Google for Android ? ", "Java", "C", "Kotlin", "C++", "Kotlin"));
        quizQuestions.add(new Quiz_Model("Q5. APK stand for ?", "Android Package Kit", "Android Phone Kit", "Android Page Kit", "App Phone Kit", "Android Package Kit"));
        quizQuestions.add(new Quiz_Model("Q6. Which of following Kernel is used in Android  ? ", "Windows NT kernel", "OpenBSD kernel", "Linux kernel", "SPARTAN kernel", "Linux kernel"));
        quizQuestions.add(new Quiz_Model("Q7. Currently Android is Owned by ? ", "Andy Robin", "James Gosling ", "Larry Page", "Google", "Google"));
        quizQuestions.add(new Quiz_Model("Q8. Which File format is Supported by Play Store for Publishing Android App ? ", "EXE", "AAB", "APK", "ABB", "APK"));
        quizQuestions.add(new Quiz_Model("Q9. Which File format is Supported by Play Store for Publishing Android App ? ", "EXE", "AAB", "APK", "ABB", "APK"));
        quizQuestions.add(new Quiz_Model("Q10. AAB Stand for ? ", "APK APP Bundle", "Application App Bundle", "Android App Bundle", "Activities Application Bundle", "Android App Bundle"));

    }

    void resetTimer() {
        timer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Timertext.setText(String.valueOf(millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {
                disableOptionButtons();
                check_btn.setBackgroundResource(R.drawable.corrrect_option_btn);

                check_btn.setEnabled(true);
            }
        };
    }

    private void checkAnswer(AppCompatButton button, String selected_Option) {
        Quiz_Model currentQuestion = quizQuestions.get(currentQuestionIndex);
        String answerOptions = currentQuestion.getCorrect_option();
        check_btn.setEnabled(true);
        check_btn.setBackgroundResource(R.drawable.corrrect_option_btn);
        check_btn.setAlpha(.75f);
        if (currentQuestionIndex == quizQuestions.size() - 1) {
            check_btn.setText("Submit");
            check_btn.setBackgroundResource(R.color.orange);
        }
        if (selected_Option.equals(answerOptions)) {
            score++;
        }

        if (selected_Option.equals(answerOptions)) {
            button.setBackgroundResource(R.drawable.corrrect_option_btn);
            button.setTextColor(getResources().getColor(R.color.color_white));
            disableOptionButtons();
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


    private void displayQuestion() {

        Quiz_Model last = null;
        Quiz_Model currentQuestion = quizQuestions.get(currentQuestionIndex);
        Question.setText(currentQuestion.getQuestion());
        option1.setText(currentQuestion.getOption1());
        option2.setText(currentQuestion.getOption2());
        option3.setText(currentQuestion.getOption3());
        option4.setText(currentQuestion.getOption4());
    }

    private void goToNextQuestion() {
        if (timer != null)
            timer.cancel();

        timer.start();

        currentQuestionIndex++;

        if (currentQuestionIndex < quizQuestions.size()) {
            // Reset button background colors
            resetButtonBackgroundColors();
            QuestionList.setText(String.format("%d/%d", (currentQuestionIndex + 1), quizQuestions.size()));

            // Enable all option buttons
            enableOptionButtons();

            // Display the next question
            displayQuestion();
        } else {


            // Quiz completed, show the final score
            Intent intent = new Intent(intro_Quiz.this, Result_Quiz.class);
            intent.putExtra("correct", score);
            intent.putExtra("total", quizQuestions.size());
            startActivity(intent);
        }
    }


    private void resetButtonBackgroundColors() {
        option1.setBackgroundResource(R.drawable.quiz_btn);
        option2.setBackgroundResource(R.drawable.quiz_btn);
        option3.setBackgroundResource(R.drawable.quiz_btn);
        option4.setBackgroundResource(R.drawable.quiz_btn);
        option1.setTextColor(getResources().getColor(R.color.black));
        option2.setTextColor(getResources().getColor(R.color.black));
        option3.setTextColor(getResources().getColor(R.color.black));
        option4.setTextColor(getResources().getColor(R.color.black));
        check_btn.setBackgroundResource(R.drawable.btn_disable);
        check_btn.setEnabled(false);

    }

    private void enableOptionButtons() {
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);
    }


    private void showWrongAnswerBottomSheet() {
        TextView CorrectAns, CancelAble;
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottomsheet_quiz, null);

        // Find the LottieAnimationView in the bottom sheet layout
        LottieAnimationView wrongAnimationView = bottomSheetView.findViewById(R.id.wrongAnimationView);
        CancelAble = bottomSheetView.findViewById(R.id.cancel_btn);


        CorrectAns = bottomSheetView.findViewById(R.id.CorrectAnser);

        Quiz_Model currentQuestion = quizQuestions.get(currentQuestionIndex);
        String answerOptions = currentQuestion.getCorrect_option();
        CorrectAns.setText(answerOptions);
        // Set up the Lottie animation
        // Create the bottom sheet dialog
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(bottomSheetView);

        // Set up the bottom sheet behavior
        bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());
        CancelAble.setOnClickListener(v -> {
            bottomSheetBehavior.isHideable();
        });
        // Show the bottom sheet
        bottomSheetDialog.show();
        CancelAble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
    }

}