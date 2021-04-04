package com.example.mvvm.Model;

/**
 * Created by Md.harun or rashid on 28,March,2021
 * BABL, Bangladesh,
 */
public class User {
    public String email;
    public String emailHint;
    public String password;
    public String passwordHint;

    public User(String emailHint,String passwordHint){
        this.emailHint=emailHint;
        this.passwordHint=passwordHint;
    }

}
