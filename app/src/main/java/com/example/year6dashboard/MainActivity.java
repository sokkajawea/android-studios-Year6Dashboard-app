package com.example.year6dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usernamepassword.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = findViewById(R.id.btnLogin);
        EditText edtUname, edtPassword;
        edtPassword = findViewById(R.id.edtPassword);
        edtUname = findViewById(R.id.edtUname);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUname.getText().toString();
                String password = edtPassword.getText().toString();

                Intent goToDash = new Intent(MainActivity.this, Dashboard.class);
                goToDash.putExtra("Username", username);

                if (username.equals("joyal")&& password.equals("john")){
                    Toast.makeText(MainActivity.this, "Logged in! Welcome "+username+".",Toast.LENGTH_SHORT).show();
                    startActivity(goToDash);
                } else if (username.equals("daniel")&& password.equals("nassif")){
                    Toast.makeText(MainActivity.this, "Logged in! Welcome "+username+".",Toast.LENGTH_SHORT).show();
                    startActivity(goToDash);
                } else if (username.equals("khalid")&& password.equals("osemi")){
                    Toast.makeText(MainActivity.this, "Logged in! Welcome "+username+".",Toast.LENGTH_SHORT).show();
                    startActivity(goToDash);
                }else if (username.equals("nana")&& password.equals("boateng")){
                    Toast.makeText(MainActivity.this, "Logged in! Welcome "+username+".",Toast.LENGTH_SHORT).show();
                    startActivity(goToDash);
                }else if (username.equals("john")&& password.equals("smith")){
                    Toast.makeText(MainActivity.this, "Logged in! Welcome "+username+".",Toast.LENGTH_SHORT).show();
                    startActivity(goToDash);
                }else if (username.equals("jason")&& password.equals("todd")){
                    Toast.makeText(MainActivity.this, "Logged in! Welcome "+username+".",Toast.LENGTH_SHORT).show();
                    startActivity(goToDash);
                }else if (username.equals("dick")&& password.equals("grayson")){
                    Toast.makeText(MainActivity.this, "Logged in! Welcome "+username+".",Toast.LENGTH_SHORT).show();
                    startActivity(goToDash);
                }else if (username.equals("jane")&& password.equals("doe")){
                    Toast.makeText(MainActivity.this, "Logged in! Welcome "+username+".",Toast.LENGTH_SHORT).show();
                    startActivity(goToDash);
                }else if (username.equals("james")&& password.equals("maddison")){
                    Toast.makeText(MainActivity.this, "Logged in! Welcome "+username+".",Toast.LENGTH_SHORT).show();
                    startActivity(goToDash);
                }else if (username.equals("miley")&& password.equals("cyrus")){
                    Toast.makeText(MainActivity.this, "Logged in! Welcome "+username+".",Toast.LENGTH_SHORT).show();
                    startActivity(goToDash);
                }else{
                    Toast.makeText(MainActivity.this, "Incorrect log in", Toast.LENGTH_SHORT).show();
                }

            }
        });





    }
}