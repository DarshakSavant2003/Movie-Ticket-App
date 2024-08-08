package com.example.app;

public class Genre {
    private String name;
    private int imageResourceId;

    public Genre(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResourceId;
    }

    public String getGenreName() {
        return name;
    }
}

