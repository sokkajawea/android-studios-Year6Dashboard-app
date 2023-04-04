package com.example.year6dashboard;

import static android.content.Intent.getIntent;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.usernamepassword.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.AccessControlContext;
import java.util.ArrayList;


public class RecyclerViewClass extends RecyclerView.Adapter<RecyclerViewClass.ViewHolder> {

    public ArrayList<Note> arrayList;
    private String username;
    public RecyclerViewClass(ArrayList<Note> dataSet, String username){
        arrayList = dataSet;
        this.username = username;
    }



    @NonNull
    @Override
    public RecyclerViewClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemlayout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewClass.ViewHolder holder, int position) {
        Note note = arrayList.get(position);
        holder.txvTitle.setText(arrayList.get(position).getTitle());
        holder.txvDesc.setText(arrayList.get(position).getDescription());
        holder.btnDelete.setTag(arrayList.get(position).getFile().getPath());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, noteEdit.class);
                intent.putExtra("title", note.getTitle());
                intent.putExtra("description", note.getDescription());
                intent.putExtra("username", username);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView txvTitle, txvDesc;
        public Button btnDelete;

        public ViewHolder(View itemView) {
            super(itemView);

            txvTitle = (TextView) itemView.findViewById(R.id.txvTitle);
            txvDesc = (TextView) itemView.findViewById(R.id.txvDesc);
            btnDelete = (Button) itemView.findViewById(R.id.btnDelete);

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String filePath = "/data/data/com.example.usernamepassword/files/notes_"+txvTitle.getText().toString().substring(1)+"_"+username+".txt";
                    File file = new File(filePath);
                    if (file.exists()) {
                        file.delete();
                        Toast.makeText(view.getContext(), "Note deleted", Toast.LENGTH_SHORT).show();
                        arrayList.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                        notifyItemRangeChanged(getAdapterPosition(), getItemCount());
                    } else {
                        Toast.makeText(view.getContext(), "File not found" + file, Toast.LENGTH_SHORT).show();
                    }
                }
            });



        }

    }

}
