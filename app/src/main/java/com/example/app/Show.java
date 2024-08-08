package com.example.app;

public class Show {
    private String name;
    private int imageResourceId;
    private String description;
    private int price;

    public Show(String name, int imageResourceId, String description,int price) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.description = description;
        this.price=price;
    }

    public String getName() {

        return name;
    }

    public int getImageResourceId() {

        return imageResourceId;
    }

    public String getDescription() {

        return description;
    }
    public int getPrice() {

        return price;
    }
}

