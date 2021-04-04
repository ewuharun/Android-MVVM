package com.example.mvvm.commands;

import com.example.mvvm.Model.Movie;
import com.example.mvvm.viewmodel.MovieModel;

/**
 * Created by Md.harun or rashid on 03,April,2021
 * BABL, Bangladesh,
 */
public interface MovieEvents {
    public void onMovieClick(Movie movieModel);
}
