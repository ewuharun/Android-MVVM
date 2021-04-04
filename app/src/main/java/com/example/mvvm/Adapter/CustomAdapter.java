package com.example.mvvm.Adapter;

import android.content.Context;
import android.os.Binder;
import android.renderscript.ScriptGroup;
import android.service.autofill.CustomDescription;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm.Model.News;
import com.example.mvvm.R;
import com.example.mvvm.databinding.NewsRowBinding;
import com.example.mvvm.viewmodel.NewsModel;

import java.util.List;

/**
 * Created by Md.harun or rashid on 01,April,2021
 * BABL, Bangladesh,
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private Context context;
    private List<NewsModel> newsList;

    public CustomAdapter(Context context, List<NewsModel> newsList){
        this.context=context;
        this.newsList=newsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NewsRowBinding newsRowBinding= DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.news_row,parent,false);
        //View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.news_row,parent,false);
        return new ViewHolder(newsRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsModel news=newsList.get(position);
        //holder.header.setText(news.header.toString());
        //holder.description.setText(news.description.toString());
        holder.bind(news);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private NewsRowBinding newsRowBinding;
        //private TextView header;
        //private TextView description;
        public ViewHolder(@NonNull NewsRowBinding itemView) {
            super(itemView.getRoot());
            //init(itemView.getRoot());

            this.newsRowBinding=itemView;



        }

        private void bind(NewsModel newsModel){
            this.newsRowBinding.setNewsList(newsModel);
        }

        public NewsRowBinding getNewsRowBinding(){
            return newsRowBinding;
        }
    }
}
