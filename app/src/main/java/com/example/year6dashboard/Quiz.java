package com.example.year6dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.usernamepassword.R;

public class Quiz extends AppCompatActivity implements View.OnClickListener {

    TextView txvTotal, txvQuestion, txvScore;
    Button btnSubmit;
    RadioButton rdBtn1,rdBtn2, rdBtn3, rdBtn4;
    int score=0;
    int totalQ = questionsAnswers.questions.length;
    int currQ =0;
    String chosenChoice = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        txvTotal = findViewById(R.id.txvTotal);
        txvQuestion = findViewById(R.id.txvQuestion);
        txvScore = findViewById(R.id.txvScore);
        rdBtn1 = findViewById(R.id.rdBtn1);
        rdBtn2 = findViewById(R.id.rdBtn2);
        rdBtn3 = findViewById(R.id.rdBtn3);
        rdBtn4 = findViewById(R.id.rdBtn4);
        btnSubmit = findViewById(R.id.btnSubmit);

        rdBtn1.setOnClickListener(this);
        rdBtn2.setOnClickListener(this);
        rdBtn3.setOnClickListener(this);
        rdBtn4.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);

        txvTotal.setText("There are "+totalQ+" questions!");

        loadQs();




    }

    void loadQs() {

        if(currQ == totalQ){
            end();
            return;
        }

        txvScore.setText("Your score is: "+ score);
        txvQuestion.setText(questionsAnswers.questions[currQ]);
        rdBtn1.setText(questionsAnswers.choices[currQ][0]);
        rdBtn2.setText(questionsAnswers.choices[currQ][1]);
        rdBtn3.setText(questionsAnswers.choices[currQ][2]);
        rdBtn4.setText(questionsAnswers.choices[currQ][3]);

    }

    void end() {

        String finalscore = "";
        if(score > totalQ*0.5){
            finalscore = "Passed!";
        }else{
            finalscore = "Failed!";
        }

        Intent recieved = getIntent();
        String username = recieved.getStringExtra("Username");


        Intent sendUser = new Intent(Quiz.this, PostQuiz.class);
        sendUser.putExtra("Username", username);
        sendUser.putExtra("score", score);
        sendUser.putExtra("status", finalscore);
        sendUser.putExtra("qTotal", totalQ);
        startActivity(sendUser);

    }

    @Override
    public void onClick(View view) {
        Button clicked = (Button) view;
        if(clicked.getId()==R.id.btnSubmit){
            currQ++;
            chosenChoice="";
            loadQs();
        }else{
            if (!chosenChoice.equals("")) {
                return;
            }
            chosenChoice = clicked.getText().toString();
            if (chosenChoice.equals(questionsAnswers.rightchoices[currQ])) {
                score++;
            }
        }
    }
}