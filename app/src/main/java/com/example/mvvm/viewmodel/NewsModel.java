package com.example.mvvm.viewmodel;

import androidx.core.view.NestedScrollingChild;
import androidx.databinding.BaseObservable;

import com.example.mvvm.Model.News;
import com.example.mvvm.R;

import java.util.ArrayList;

/**
 * Created by Md.harun or rashid on 31,March,2021
 * BABL, Bangladesh,
 */
public class NewsModel extends BaseObservable {
    String header;
    String description;
    ArrayList<News> newsList=new ArrayList<>();


    public NewsModel(News news){
        this.header=news.header;
        this.description=news.description;
    }


    public NewsModel() {

    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
        notifyPropertyChanged(R.id.header);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(R.id.description);
    }

    public ArrayList<NewsModel> getNewsList(){
        ArrayList<NewsModel> newsArrayList=new ArrayList<>();

        newsArrayList.add(new NewsModel(new News("Header 1 ","Descr 1 ")));
        newsArrayList.add(new NewsModel(new News("Header 1 ","Descr 1 ")));


        return newsArrayList;
    }
}
