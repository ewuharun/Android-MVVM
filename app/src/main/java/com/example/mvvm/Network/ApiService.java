package com.example.mvvm.Network;

import com.example.mvvm.Model.Movie;
import com.example.mvvm.viewmodel.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Md.harun or rashid on 03,April,2021
 * BABL, Bangladesh,
 */
public interface ApiService {
    @GET("volley_array.json")
    Call<List<Movie>> getMovieList();
}
