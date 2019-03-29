package com.example.abdo.codeforcesapp;

public class Contestant {
    private String name;
    private int rating;
    private String rank;

    public Contestant(String name, int rating, String rank) {
        this.name = name;
        this.rating = rating;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
