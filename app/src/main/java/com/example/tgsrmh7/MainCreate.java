package com.example.tgsrmh7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private com.example.tgsrmh7.MyDatabase db;
    private EditText Enama, Eauthor, Epenerbit;
    private String Snama, Sauthor, Spenerbit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new com.example.tgsrmh7.MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Eauthor = (EditText) findViewById(R.id.create_author);
        Epenerbit = (EditText) findViewById(R.id.create_penerbit);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sauthor = String.valueOf(Eauthor.getText());
                Spenerbit = String.valueOf(Epenerbit.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi judul buku", Toast.LENGTH_SHORT).show();
                }
                else if (Sauthor.equals("")) {
                    Eauthor.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi author", Toast.LENGTH_SHORT).show();
                }
                else if (Spenerbit.equals("")) {
                    Epenerbit.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi penerbit", Toast.LENGTH_SHORT).show();
                }
                else {
                    Enama.setText("");
                    Eauthor.setText("");
                    Epenerbit.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreateBuku(new Buku(null, Snama, Sauthor, Spenerbit));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

