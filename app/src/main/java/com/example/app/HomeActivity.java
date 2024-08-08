package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager2 recommendedViewPager = findViewById(R.id.recommendedViewPager);
        CustomPagerAdapter recommendedPagerAdapter = new CustomPagerAdapter(this);

        // Add recommended movie posters
        recommendedPagerAdapter.addImage(R.drawable.ticket);
        recommendedPagerAdapter.addImage(R.drawable.slider);
        recommendedPagerAdapter.addImage(R.drawable.comedy);
        recommendedPagerAdapter.addImage(R.drawable.kgf);

        recommendedViewPager.setAdapter(recommendedPagerAdapter);





        Button btnAllMovies = findViewById(R.id.btnAllMovies);
        Button btnAllCategories = findViewById(R.id.btnAllCategories);
        Button btnMyProfile = findViewById(R.id.btnMyProfile);
        Button btnUpdateProfile = findViewById(R.id.btnUpdateProfile);


        btnAllMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this, AllMoviesActivity.class);
                startActivity(intent);
            }
        });


        btnAllCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this, AllCategoriesActivity.class);
                startActivity(intent);
            }
        });


        btnMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this, MyProfileActivity.class);
                startActivity(intent);
            }
        });


        btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this, UpdateProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
