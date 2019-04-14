package com.example.abdo.codeforcesapp;

public class User  {
    private String username;
    private int rating;
    private int maxRating;
    private String rank;
    private int friends;
    private String picURL;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getMaxRating() {
        return maxRating;
    }

    public void setMaxRating(int maxRating) {
        this.maxRating = maxRating;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getFriends() {
        return friends;
    }

    public void setFriends(int friends) {
        this.friends = friends;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public User(String username, int rating, int maxRating, String rank, int friends, String picURL) {
        this.username = username;
        this.rating = rating;
        this.maxRating = maxRating;
        this.rank = rank;
        this.friends = friends;
        this.picURL = picURL;
    }
}
