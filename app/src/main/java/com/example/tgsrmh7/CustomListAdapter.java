package com.example.tgsrmh7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Buku> Buku;
    public CustomListAdapter(Activity activity, List<Buku> Buku) {
        this.activity = activity;
        this.Buku = Buku;
    }
    @Override
    public int getCount() {
        return Buku.size();
    }
    @Override
    public Object getItem(int location) {
        return Buku.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView author = (TextView) convertView.findViewById(R.id.text_author);
        TextView penerbit = (TextView) convertView.findViewById(R.id.text_penerbit);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);
        Buku b = Buku.get(position);
        nama.setText("Judul : "+ b.get_nama());
        author.setText("Author : "+ b.get_author());
        penerbit.setText("Penerbit : "+ b.get_penerbit());
        return convertView;
    }
}
