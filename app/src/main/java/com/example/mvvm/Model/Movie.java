package com.example.mvvm.Model;

/**
 * Created by Md.harun or rashid on 03,April,2021
 * BABL, Bangladesh,
 */
public class Movie {

    private String title;
    private String image;


    public Movie(String title, String image) {
        this.title = title;
        this.image = image;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
