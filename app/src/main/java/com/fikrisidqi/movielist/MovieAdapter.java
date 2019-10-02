package com.fikrisidqi.movielist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    Context context;
    ArrayList<Movie> movie;

    public MovieAdapter(Context context, ArrayList<Movie> ourMovie){
        this.context = context;
        this.movie = ourMovie;
    }

    @Override
    //getCount  yang berfungsi untuk mendapatkan jumlah item yang ditampilkan pada listView
    public int getCount() {
        return movie.size();
    }

    @Override
    //getItem  yang berfungsi untuk mengembalikan nilai objek pada posisi ke-i dari daftar ListView
    public Object getItem(int i) {
        return movie.get(i);
    }

    @Override
    //getItemId untuk mendapatkan nilai id dari objek pada posisi ke-i
    public long getItemId(int i) {
        return i;
    }

    @Override
    //getView  berfungsi untuk mendapatkan view bagi objek pada posisi ke-i
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;

        if (view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.movie_item, null);

            holder.Foto = view.findViewById(R.id.mov_image);
            holder.Nama = view.findViewById(R.id.mov_name);
            holder.Des = view.findViewById(R.id.mov_desc);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        holder.Foto.setImageResource(movie.get(i).getImageRes());
        holder.Nama.setText(movie.get(i).getMovName());
        holder.Des.setText(movie.get(i).getMovDesc());

        return view;
    }

    static class ViewHolder {
        ImageView Foto;
        TextView Nama;
        TextView Des;
    }
}
