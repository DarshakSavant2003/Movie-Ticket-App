package com.example.app;

public class UserInformation {
    private String username;
    private String name;
    private String gender;

    public UserInformation(String username, String name, String gender) {
        this.username = username;
        this.name = name;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
}
