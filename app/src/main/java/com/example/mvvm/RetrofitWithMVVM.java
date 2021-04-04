package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvm.Adapter.MovieAdapter;
import com.example.mvvm.Model.Movie;
import com.example.mvvm.commands.MovieEvents;
import com.example.mvvm.databinding.ActivityMainBinding;
import com.example.mvvm.viewmodel.MovieModel;

import java.util.List;

public class RetrofitWithMVVM extends AppCompatActivity implements MovieEvents {
    private RecyclerView movieRecyclearView;
    private List<Movie> movieList;
    private MovieAdapter movieAdapter;
    private MovieModel viewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_with_m_v_v_m);


        init();

        LinearLayoutManager linearLayoutManager=new GridLayoutManager(this,2);
        movieRecyclearView.setLayoutManager(linearLayoutManager);
        movieAdapter=new MovieAdapter(this,movieList,this);
        movieRecyclearView.setAdapter(movieAdapter);


        viewModel= ViewModelProviders.of(this).get(MovieModel.class);

        viewModel.getObserver().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                if(movies!=null){
                    movieList=movies;
                    movieAdapter.setMovieList(movieList);
                }
            }
        });

        viewModel.makeApiCall();

    }

    private void init() {
        movieRecyclearView=findViewById(R.id.movieRecyclearView);
    }

    @Override
    public void onMovieClick(Movie movieModel) {
        Toast.makeText(this, "Clicked Movie Name is : " +movieModel.getTitle(), Toast.LENGTH_SHORT).show();
    }
}