package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvvm.Adapter.CustomAdapter;
import com.example.mvvm.Model.News;
import com.example.mvvm.viewmodel.NewsModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclearBindingActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ArrayList<NewsModel> newsList;

    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclear_binding);

        init();

        newsList.add(new NewsModel(new News("header1","description1")));
        newsList.add(new NewsModel(new News("header2","description2")));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new CustomAdapter(RecyclearBindingActivity.this,newsList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    private void init() {
        recyclerView=findViewById(R.id.recyclearView);
        newsList=new ArrayList<>();
    }


}