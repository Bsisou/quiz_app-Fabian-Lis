package com.bsisou.quiz;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare constants heres

    // TODO: Declare member variables here:
    Button trueButton;
    Button falseButton;
    TextView scoreTextView;
    TextView questionTextView;
    ProgressBar progressBar;
    int index;
    int question;
    int score;

    // TODO: to create question bank
    private final TrueFalse[] questionBank = new com.bsisou.quiz.TrueFalse[]{
            new TrueFalse(R.string.question_1, false),
            new TrueFalse(R.string.question_2, false),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, false),
            new TrueFalse(R.string.question_6, true),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, true),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13, true)
    };
    final int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100.0 / questionBank.length);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        trueButton = findViewById(R.id.true_button);
        falseButton =findViewById(R.id.false_button);
        questionTextView = findViewById(R.id.question_text_view);
        scoreTextView = findViewById(R.id.score);
        progressBar = findViewById(R.id.progress_bar);
        question = questionBank[index].getQuestionID();
        questionTextView.setText(question);

        trueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Quiz","True button pressed");
                checkAnswer(true);
                updateQuestion();

            }
        });

        falseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Quiz","false button pressed");
                checkAnswer(false);
                updateQuestion();
            }
        });
    }
    @SuppressLint("SetTextI18n")
    private void updateQuestion(){
        index = (index + 1) % questionBank.length;
        if (index == 0){
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("Your score " + score + " points");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which){
                    finish();
                }
            });
            alert.show();
        }
        question = questionBank[index].getQuestionID();
        questionTextView.setText(question);
        progressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        scoreTextView.setText("Score" + score + "/" + questionBank.length);
    }

    private void checkAnswer(boolean UserSelection){

        boolean correctAnswer = questionBank[index].getAnswer();

        if(UserSelection == correctAnswer){
            Toast toastMessage = Toast.makeText(getApplicationContext(),"Awsome! well done", Toast.LENGTH_LONG);
            score+=1;
        } else {
            Toast toastMessage = Toast.makeText(getApplicationContext(),"OPS! Not Right", Toast.LENGTH_LONG);
        }
    }
}
