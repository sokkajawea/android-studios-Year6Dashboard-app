package com.example.year6dashboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usernamepassword.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Notes extends AppCompatActivity {

    public ArrayList<Note> notes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Intent recieved = getIntent();
        String username = recieved.getStringExtra("Username");

        loadNotes();



        RecyclerView rvNotes = findViewById(R.id.rvNotes);
        RecyclerViewClass rv = new RecyclerViewClass(notes, username);
        rvNotes.setLayoutManager(new LinearLayoutManager(this));
        rvNotes.setAdapter(rv);


        FloatingActionButton btnAdd = findViewById(R.id.btnAdd);
        FloatingActionButton btnBackToDash = findViewById(R.id.btnBackToDash);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the custom layout for the dialog
                LayoutInflater inflater = LayoutInflater.from(Notes.this);
                View dialogView = inflater.inflate(R.layout.dialog_new_note, null);

                // Find the EditTexts in the custom layout
                EditText titleInput = dialogView.findViewById(R.id.etNoteTitle);
                EditText descriptionInput = dialogView.findViewById(R.id.etNoteDescription);

                // Show the dialog with the custom layout
                AlertDialog.Builder builder = new AlertDialog.Builder(Notes.this);
                builder.setView(dialogView);
                builder.setTitle("New Note");

                // Set up the buttons
                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String noteTitle = titleInput.getText().toString();
                        String noteDescription = descriptionInput.getText().toString();
                        Note note = new Note("-"+noteTitle, noteDescription, getFilesDir().toString());
                        notes.add(note);

                        rv.notifyDataSetChanged();

                        try {
                            String filename = "notes_" + noteTitle + "_"+username+".txt";
                            FileOutputStream fos = openFileOutput(filename, MODE_PRIVATE);
                            String fileContents = "Title: " +noteTitle+ "\nDescription: "+noteDescription;
                            fos.write(fileContents.getBytes());
                            fos.write("\n".getBytes());
                            fos.close();
                            Toast.makeText(Notes.this, "Note saved!", Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });

        btnBackToDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendUser = new Intent(Notes.this, Dashboard.class);
                sendUser.putExtra("Username", username);
                startActivity(sendUser);
            }
        });
    }

    private void loadNotes() {

        Intent recieved = getIntent();
        String username = recieved.getStringExtra("Username");
        // Clear the notes array list before adding loaded notes
        notes.clear();

        // Get a list of all the files with prefix "notes_"
        String[] fileList = fileList();
        ArrayList<String> noteFiles = new ArrayList<>();
        for (String file : fileList) {
            if (file.endsWith(username+".txt")) {
                noteFiles.add(file);
            }
        }

        // Load the notes from each file into the notes array list
        for (String filename : noteFiles) {
            try {
                FileInputStream fis = openFileInput(filename);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                String noteTitle = "";
                String noteDescription = "";
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith("Title: ")) {
                        noteTitle = line.substring(7);
                    } else if (line.startsWith("Description: ")) {
                        noteDescription = line.substring(13);
                    }
                }

                Note note = new Note("-" + noteTitle, noteDescription, getFilesDir().toString());
                notes.add(note);

                br.close();
                isr.close();
                fis.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}