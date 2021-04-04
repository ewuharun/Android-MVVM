package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mvvm.Adapter.NewsAdapter;
import com.example.mvvm.Model.News;
import com.example.mvvm.commands.UserLoginEvents;
import com.example.mvvm.databinding.ActivityMainBinding;
import com.example.mvvm.Model.User;
import com.example.mvvm.viewmodel.NewsModel;
import com.example.mvvm.viewmodel.UserModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    ListView listView;
    NewsModel newsModel;
    NewsAdapter newsAdapter;
    News news;

    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding= DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);

        //This 2 line is for Binding the data with the layout file
        UserModel userModel=new UserModel(new User("EnterEmail","EnterPassword"));
        activityMainBinding.setUserModel(userModel);
        activityMainBinding.executePendingBindings();


        activityMainBinding.setUserLoginEvents(new UserLoginEvents() {
            @Override
            public void onClickedLoginBtn() {
                Toast.makeText(MainActivity.this,activityMainBinding.getUserModel().getEmail(), Toast.LENGTH_SHORT).show();
            }
        });




        listView=findViewById(R.id.listView);
        ArrayList<NewsModel> news=new ArrayList<>();
        newsModel=new NewsModel();
        news=newsModel.getNewsList();


        newsAdapter=new NewsAdapter(this,news);
        activityMainBinding.listView.setAdapter(newsAdapter);


    }

    public void gotoRecyclearViewBinding(View view) {
        Intent intent=new Intent(MainActivity.this,RecyclearBindingActivity.class);
        startActivity(intent);
        finish();
    }

    public void gotoBaseObservableBinding(View view) {
        Intent intent=new Intent(MainActivity.this,BaseObservableBinding.class);
        startActivity(intent);
    }

    public void gotoMovie(View view) {
        Intent intent=new Intent(MainActivity.this,RetrofitWithMVVM.class);
        startActivity(intent);
    }
}