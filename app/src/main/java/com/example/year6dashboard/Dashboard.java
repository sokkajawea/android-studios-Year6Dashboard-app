package com.example.year6dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.usernamepassword.R;

public class Dashboard extends AppCompatActivity {

    Button btnCalc, btnBackground, btnQuiz,btnNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Intent recieved = getIntent();
        String username = recieved.getStringExtra("Username");

        TextView txvWelcome = findViewById(R.id.txvWelcome);

        txvWelcome.setText("Welcome, "+username+"!");



        btnCalc = findViewById(R.id.btnCalc);
        btnBackground = findViewById(R.id.btnBackground);
        btnQuiz = findViewById(R.id.btnQuiz);
        btnNotes = findViewById(R.id.btnNotes);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendOff = new Intent(Dashboard.this, Calculator.class);
                sendOff.putExtra("Username", username);
                startActivity(sendOff);
            }
        });

        btnBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendOff = new Intent(Dashboard.this, changeBackground.class);
                sendOff.putExtra("Username", username);
                startActivity(sendOff);
            }
        });

        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendOff = new Intent(Dashboard.this, Quiz.class);
                sendOff.putExtra("Username", username);
                startActivity(sendOff);
            }
        });

        btnNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendOff = new Intent(Dashboard.this, Notes.class);
                sendOff.putExtra("Username", username);
                startActivity(sendOff);
            }
        });


    }
}