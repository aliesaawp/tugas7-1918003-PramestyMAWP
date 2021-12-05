package com.example.tgsrmh7;

public class Buku
{ private String _id, _nama, _author, _penerbit;
    public Buku(String id, String nama, String author, String penerbit) {
        this._id = id;
        this._nama = nama;
        this._author = author;
        this._penerbit = penerbit;
    }
    public Buku() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_author() {
        return _author;
    }
    public void set_author(String _author) {
        this._author = _author;
    }
    public String get_penerbit() {

        return _penerbit;
    }
    public void set_penerbit(String _penerbit) {
        this._penerbit = _penerbit;
    }
}
