package com.example.topmovies;

import java.io.Serializable;

public class Movie implements Serializable {



    private String name;
    private int year;
    private String genre;
    private boolean isAnimation;
    private int img;
    private int rank;


    public Movie(String name, int year, String genre, boolean isAnimation , int img, int rank)
    {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.isAnimation = true;
        this.img = img;
        this.rank = rank;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isAnimation() {
        return isAnimation;
    }

    public void setAnimation(boolean animation) {
        isAnimation = animation;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
