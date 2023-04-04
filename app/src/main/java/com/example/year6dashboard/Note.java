package com.example.year6dashboard;

import android.util.Log;

import java.io.File;

public class Note {
    private String title;
    private String description;
    private String filePath;

    public Note(String title, String description, String filePath) {
        this.title = title;
        this.description = description;
        this.filePath = filePath;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public File getFile() {
        return new File(filePath);
    }

    public String getFilename(String username) {
        return "notes_" + title.substring(1) + "_" + username + ".txt";
    }
}
