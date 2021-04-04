package com.example.mvvm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.mvvm.MainActivity;
import com.example.mvvm.Model.News;
import com.example.mvvm.R;
import com.example.mvvm.databinding.NewsRowBinding;
import com.example.mvvm.viewmodel.NewsModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.mvvm.R.layout.*;

/**
 * Created by Md.harun or rashid on 31,March,2021
 * BABL, Bangladesh,
 */
public class NewsAdapter extends ArrayAdapter<NewsModel> {

    private Context context;

    private ArrayList<NewsModel> newsModelArrayList;

    public NewsAdapter(Context context, ArrayList<NewsModel> newsModels) {
        super(context, R.layout.news_row,newsModels);
        this.context=context;
        this.newsModelArrayList=newsModels;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        NewsRowBinding newsRowBinding= DataBindingUtil.inflate(inflater, news_row,parent,false);
        newsRowBinding.setNewsList(newsModelArrayList.get(position));

        return newsRowBinding.getRoot();
    }
}
