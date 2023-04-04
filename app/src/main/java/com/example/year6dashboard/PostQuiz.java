package com.example.year6dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usernamepassword.R;

import java.io.FileOutputStream;
import java.io.IOException;

public class PostQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_quiz);

        Intent scoreRecieve = getIntent();
        int score = scoreRecieve.getIntExtra("score",0);

        Intent statusRecieve= getIntent();
        String status = statusRecieve.getStringExtra("status");

        TextView txvFinalScore = findViewById(R.id.txvFinalScore);

        txvFinalScore.setText("Your score is: " + score+". You "+ status);


        Intent recieved = getIntent();
        String username = recieved.getStringExtra("Username");

        Intent backToDash = new Intent(PostQuiz.this, Dashboard.class);
        backToDash.putExtra("Username", username);

        Button btnDash = findViewById(R.id.btnDash);
        Button btnSave = findViewById(R.id.btnSave);

        btnDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(backToDash);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = "scoreboard.txt";
                String fileContents = getIntent().getStringExtra("Username") + " got: " + getIntent().getIntExtra("score", 0)+" out of " + getIntent().getStringExtra("qTotal") +". They "+getIntent().getStringExtra("status");

                try {
                    FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
                    fos.write(fileContents.getBytes());
                    fos.write("\n".getBytes());
                    fos.close();
                    Toast.makeText(getApplicationContext(), "Score saved successfully to: " + getFilesDir(), Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}