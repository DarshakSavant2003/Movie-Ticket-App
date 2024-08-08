package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GenreAdapter extends ArrayAdapter<Genre> {

    public GenreAdapter(Context context, List<Genre> genres) {
        super(context, 0, genres);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Genre currentGenre = getItem(position);

        ImageView genreImage = listItemView.findViewById(R.id.genreImage);
        genreImage.setImageResource(currentGenre.getImageResource());

        TextView genreName = listItemView.findViewById(R.id.genreName);
        genreName.setText(currentGenre.getGenreName());

        return listItemView;
    }
}

