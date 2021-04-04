package com.example.mvvm.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.mvvm.BR;
import com.example.mvvm.Model.User;
import com.example.mvvm.R;

/**
 * Created by Md.harun or rashid on 28,March,2021
 * BABL, Bangladesh,
 */
public class UserModel extends BaseObservable {
    public String email;
    public String emailHint;
    public String password;
    public String passwordHint;

    public UserModel(User user){
        this.emailHint=user.emailHint;
        this.passwordHint=user.passwordHint;
    }
    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

        notifyPropertyChanged(BR.email);
    }

    public String getEmailHint() {
        return emailHint;
    }

    public void setEmailHint(String emailHint) {
        this.emailHint = emailHint;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }
}
