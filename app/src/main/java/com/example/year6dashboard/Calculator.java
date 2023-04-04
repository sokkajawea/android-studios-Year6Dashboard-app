package com.example.year6dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.usernamepassword.R;

public class Calculator extends AppCompatActivity {

    boolean Add, Sub, Multiply, Divide, deci;
    TextView txvMainScreen;
    double in1 = 0, i2 = 0;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnBack, btnClear, btnEquals, btnPlus, btnMinus, btnMultiply, btnDivide, btnDecimal, btnDash;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Intent recieved = getIntent();
        String username = recieved.getStringExtra("Username");


        txvMainScreen = findViewById(R.id.txvMainScreen);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnDivide = findViewById(R.id.btnDivide);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnEquals = findViewById(R.id.btnEquals);
        btnClear = findViewById(R.id.btnClear);
        btnBack = findViewById(R.id.btnBack);
        btnDecimal = findViewById(R.id.btnDecimal);
        btnDash = findViewById(R.id.btnDash);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txvMainScreen.setText(txvMainScreen.getText() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txvMainScreen.setText(txvMainScreen.getText() + "2");
            }

        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txvMainScreen.setText(txvMainScreen.getText() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txvMainScreen.setText(txvMainScreen.getText() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txvMainScreen.setText(txvMainScreen.getText() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txvMainScreen.setText(txvMainScreen.getText() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txvMainScreen.setText(txvMainScreen.getText() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txvMainScreen.setText(txvMainScreen.getText() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txvMainScreen.setText(txvMainScreen.getText() + "9");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txvMainScreen.setText(txvMainScreen.getText() + "0");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txvMainScreen.getText().length() != 0) {
                    in1 = Float.parseFloat(txvMainScreen.getText() + "");
                    Add = true;
                    deci = false;
                    txvMainScreen.setText(null);
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txvMainScreen.getText().length() != 0) {
                    in1 = Float.parseFloat(txvMainScreen.getText() + "");
                    Sub = true;
                    deci = false;
                    txvMainScreen.setText(null);
                }
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txvMainScreen.getText().length() != 0) {
                    in1 = Double.parseDouble(txvMainScreen.getText() + "");
                    Multiply = true;
                    deci = false;
                    txvMainScreen.setText(null);
                }
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txvMainScreen.getText().length() != 0) {
                    in1 = Float.parseFloat(txvMainScreen.getText() + "");
                    Divide = true;
                    deci = false;
                    txvMainScreen.setText(null);
                }
            }
        });

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deci) {

                } else {
                    txvMainScreen.setText(txvMainScreen.getText() + ".");
                    deci = true;
                }

            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Add || Sub || Multiply || Divide) {
                    i2 = Float.parseFloat(txvMainScreen.getText() + "");
                }

                if (Add) {

                    txvMainScreen.setText(in1 + i2 + "");
                    Add = false;
                }

                if (Sub) {

                    txvMainScreen.setText(in1 - i2 + "");
                    Sub = false;
                }

                if (Multiply) {
                    txvMainScreen.setText(in1 * i2 + "");
                    Multiply = false;
                }

                if (Divide) {
                    txvMainScreen.setText(in1 / i2 + "");
                    Divide = false;
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txvMainScreen.setText("");
                in1 = 0.0;
                i2 = 0.0;
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = txvMainScreen.getText().toString();
                if(str.length() >= 1){
                    str = str.substring(0, str.length() - 1);
                    txvMainScreen.setText(str);
                }
            }
        });

        btnDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToDash = new Intent(Calculator.this, Dashboard.class);
                backToDash.putExtra("Username", username);
                startActivity(backToDash);
            }
        });




    }
}