package com.example.mvvm.Model;

import com.example.mvvm.viewmodel.NewsModel;

import java.util.ArrayList;

/**
 * Created by Md.harun or rashid on 31,March,2021
 * BABL, Bangladesh,
 */
public class News {
    public String header;
    public String description;

    public News(String header,String description){
        this.header=header;
        this.description=description;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
