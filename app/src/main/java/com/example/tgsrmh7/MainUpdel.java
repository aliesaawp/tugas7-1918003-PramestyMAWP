package com.example.tgsrmh7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sauthor, Spenerbit;
    private EditText Enama, Eauthor, Epenerbit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sauthor = i.getStringExtra("Iauthor");
        Spenerbit = i.getStringExtra("Ipenerbit");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Eauthor = (EditText) findViewById(R.id.updel_author);
        Epenerbit = (EditText) findViewById(R.id.updel_penerbit);
        Enama.setText(Snama);
        Eauthor.setText(Sauthor);
        Epenerbit.setText(Spenerbit);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sauthor = String.valueOf(Eauthor.getText());
                Spenerbit = String.valueOf(Epenerbit.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi judul",
                            Toast.LENGTH_SHORT).show();
                } else if (Sauthor.equals("")){
                    Eauthor.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi author",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Spenerbit.equals("")){
                    Epenerbit.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi penerbit",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateBuku(new Buku(Sid, Snama, Sauthor, Spenerbit));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteBuku(new Buku(Sid, Snama, Sauthor, Spenerbit));
                Toast.makeText(MainUpdel.this, "Data telah dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
