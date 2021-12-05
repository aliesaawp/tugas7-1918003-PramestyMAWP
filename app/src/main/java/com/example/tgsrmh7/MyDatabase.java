package com.example.tgsrmh7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_B]buku";
    private static final String tb_buku = "tb_buku";
    private static final String tb_buku_id = "id";
    private static final String tb_buku_nama = "nama";
    private static final String tb_buku_author = "author";
    private static final String tb_buku_penerbit = "penerbit";
    private static final String CREATE_TABLE_BUKU = "CREATE TABLE " + tb_buku +"(" + tb_buku_id + " INTEGER PRIMARY KEY ," + tb_buku_nama + " TEXT ," + tb_buku_author + " TEXT ," + tb_buku_penerbit +" TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BUKU);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void CreateBuku(Buku data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_buku_id, data.get_id());
        values.put(tb_buku_nama, data.get_nama());
        values.put(tb_buku_author, data.get_author());
        values.put(tb_buku_penerbit, data.get_penerbit());
        db.insert(tb_buku, null, values);
        db.close();
    }
    public List<Buku> ReadBuku (){
        List<Buku> listMhs = new ArrayList<Buku>();
        String selectQuery = "SELECT * FROM " + tb_buku;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Buku data = new Buku();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_author(cursor.getString(2));
                data.set_penerbit(cursor.getString(3));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }
    public int UpdateBuku (Buku data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_buku_nama, data.get_nama());
        values.put(tb_buku_author, data.get_author());
        values.put(tb_buku_penerbit, data.get_penerbit());
        return db.update(tb_buku, values, tb_buku_id + " = ?", new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteBuku(Buku data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_buku,tb_buku_id+ " = ?", new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
