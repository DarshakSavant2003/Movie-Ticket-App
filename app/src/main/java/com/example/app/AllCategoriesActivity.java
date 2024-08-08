package com.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class AllCategoriesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);


        ArrayList<Genre> genres = new ArrayList<>();
        genres.add(new Genre("Horror", R.drawable.horror));
        genres.add(new Genre("Action", R.drawable.action));
        genres.add(new Genre("Comedy", R.drawable.comedyy));
        genres.add(new Genre("Fiction", R.drawable.fiction));
        genres.add(new Genre("Concerts", R.drawable.concert));
        // Create a custom adapter
        GenreAdapter adapter = new GenreAdapter(this, genres);


        ListView listView = findViewById(android.R.id.list);

        // Set the adapter on the ListView
        listView.setAdapter(adapter);
    }
}
