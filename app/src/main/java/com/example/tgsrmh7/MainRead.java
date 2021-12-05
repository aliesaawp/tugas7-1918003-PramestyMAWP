package com.example.tgsrmh7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Buku> listBuku = new ArrayList<Buku>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, listBuku);
        mListView = (ListView) findViewById(R.id.list_jenis);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        listBuku.clear();
        List<Buku> Buku = db.ReadBuku();
        for (Buku bk : Buku) {
            Buku book = new Buku();
            book.set_id(bk.get_id());
            book.set_nama(bk.get_nama());
            book.set_author(bk.get_author());
            book.set_penerbit(bk.get_penerbit());
            listBuku.add(book);
            if ((listBuku.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Buku detailBook = (Buku) o;
        String Sid = detailBook.get_id();
        String Snama = detailBook.get_nama();
        String Sauthor = detailBook.get_author();
        String Spenerbit = detailBook.get_penerbit();
        Intent goUpdel = new Intent(MainRead.this, com.example.tgsrmh7.MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Iauthor", Sauthor);
        goUpdel.putExtra("Ipenerbit", Spenerbit);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        listBuku.clear();
        mListView.setAdapter(adapter_off);
        List<Buku> buku = db.ReadBuku();
        for (Buku bk : buku) {
            Buku bukuu = new Buku();
            bukuu.set_id(bk.get_id());
            bukuu.set_nama(bk.get_nama());
            bukuu.set_author(bk.get_author());
            bukuu.set_penerbit(bk.get_penerbit());
            listBuku.add(bukuu);
            if ((listBuku.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
