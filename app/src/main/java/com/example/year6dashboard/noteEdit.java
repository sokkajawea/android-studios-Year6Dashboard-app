package com.example.year6dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usernamepassword.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileWriter;
import java.io.IOException;

public class noteEdit extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        EditText edtTitle, edtDesc;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);

        FloatingActionButton btnSave;

        edtTitle = findViewById(R.id.edtTitle);
        edtDesc = findViewById(R.id.edtDesc);
        btnSave = findViewById(R.id.btnSave);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title").substring(1);
        String desc = intent.getStringExtra("description");
        String username = intent.getStringExtra("username");

        edtTitle.setText(title);
        edtDesc.setText(desc);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTitle = edtTitle.getText().toString();
                String newDesc = edtDesc.getText().toString();

                try {
                    String filePath = "/data/data/com.example.usernamepassword/files/notes_"+title+"_"+username+".txt";
                    FileWriter fileWriter = new FileWriter(filePath);
                    String fileContents = "Title: " +newTitle+ "\nDescription: "+newDesc;
                    fileWriter.write(fileContents);
                    fileWriter.flush();
                    fileWriter.close();
                    Toast.makeText(noteEdit.this, "Note updated", Toast.LENGTH_SHORT).show();

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("title", newTitle);
                    resultIntent.putExtra("description", newDesc);
                    setResult(RESULT_OK, resultIntent);

                    // Close the activity and return to the previous one
                    finish();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}