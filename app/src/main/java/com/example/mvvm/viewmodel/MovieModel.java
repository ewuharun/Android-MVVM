package com.example.mvvm.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.Model.Movie;
import com.example.mvvm.Network.ApiService;
import com.example.mvvm.Network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Md.harun or rashid on 03,April,2021
 * BABL, Bangladesh,
 */
public class MovieModel extends ViewModel {

    private MutableLiveData<List<Movie>> movieList;

    public MovieModel(){
        movieList=new MutableLiveData<>();
    }

    public MutableLiveData<List<Movie>> getObserver(){
        return movieList;
    }

    public void makeApiCall(){
        ApiService apiService= RetroInstance.getRetrofitClient().create(ApiService.class);
        Call<List<Movie>> call=apiService.getMovieList();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                movieList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                movieList.postValue(null);
            }
        });
    }
}
