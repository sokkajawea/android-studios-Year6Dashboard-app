package com.example.year6dashboard;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.usernamepassword.R;

public class changeBackground extends AppCompatActivity {

    private EditText edtColour;
    private LinearLayout mainLayout;
    Button btnDash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_background);

        Intent recieved = getIntent();
        String username = recieved.getStringExtra("Username");


        edtColour = findViewById(R.id.edtColour);
        mainLayout = findViewById(R.id.mainLayout);

        edtColour.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    mainLayout.setBackgroundColor(Color.WHITE);
                } else {
                    try {
                        int color = Color.parseColor(s.toString());
                        mainLayout.setBackgroundColor(color);
                    } catch (IllegalArgumentException e) {
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        btnDash = findViewById(R.id.btnDash);
        btnDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToDash = new Intent(changeBackground.this, Dashboard.class);
                backToDash.putExtra("Username", username);
                startActivity(backToDash);
            }
        });


    }
}