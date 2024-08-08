package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AllMoviesActivity extends AppCompatActivity {

    private ListView listView;
    private ShowAdapter adapter; // Custom adapter for Show objects

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_movies);

        listView = findViewById(R.id.showListView);


        List<Show> shows = new ArrayList<>();

        shows.add(new Show("Era's Tour", R.drawable.concert, "The tour recaps all ten of Swift's studio albums, presenting each as an epoch, with its own elaborate sets, costumes, and vibes. (The scope of the show reinforces the hysterical demands on twenty-first-century pop stars: be something new every time you show up, or don't show up at all",2000));
        shows.add(new Show("KGF Chapter 2", R.drawable.kgf, "The blood-soaked land of Kolar Gold Fields (KGF) has a new overlord now - Rocky, whose name strikes fear in the heart of his foes. His allies look up to Rocky as their savior, the government sees him as a threat to law and order; enemies are clamoring for revenge and conspiring for his downfall.",5000));


        // Create a custom adapter for the list view
        adapter = new ShowAdapter(this, shows);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Show selectedShow = shows.get(position);

                ShowDetailsDialogFragment dialogFragment = new ShowDetailsDialogFragment();
                Bundle args = new Bundle();
                args.putString("showName", selectedShow.getName());

                args.putString("description", selectedShow.getDescription());
                args.putInt("price", selectedShow.getPrice());
                dialogFragment.setArguments(args);
                dialogFragment.show(getSupportFragmentManager(), "ShowDetailsDialog");
            }
        });

    }
}
