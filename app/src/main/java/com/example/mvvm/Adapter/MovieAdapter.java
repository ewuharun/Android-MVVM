package com.example.mvvm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvm.Model.Movie;
import com.example.mvvm.R;
import com.example.mvvm.viewmodel.MovieModel;

import com.example.mvvm.commands.MovieEvents;

import java.util.List;

/**
 * Created by Md.harun or rashid on 03,April,2021
 * BABL, Bangladesh,
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context context;
    private List<Movie> movieList;
    private MovieEvents movieEvents;

    public MovieAdapter(Context context, List<Movie> movieList, MovieEvents movieEvents) {
        this.context = context;
        this.movieList = movieList;
        this.movieEvents = movieEvents;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclear_row,parent,false);
        //LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclear_row,parent);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        Movie movieModel=movieList.get(position);
        holder.titleTextView.setText(movieModel.getTitle().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieEvents.onMovieClick(movieList.get(position));
            }
        });

        Glide.with(context)
                .load(this.movieList.get(position).getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageView);
    }



    @Override
    public int getItemCount() {
        if(this.movieList!=null){
            return this.movieList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView=itemView.findViewById(R.id.titleView);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }
}
