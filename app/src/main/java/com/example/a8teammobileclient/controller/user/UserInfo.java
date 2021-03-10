package com.example.a8teammobileclient.controller.user;

import androidx.fragment.app.Fragment;

import com.example.a8teammobileclient.entity.User;
import com.example.a8teammobileclient.ui.authentication.LoginFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInfo implements Callback<User> {
    private final Fragment fragment;
    public static String id;
    public UserInfo(Fragment fragment){
        this.fragment = fragment;
    }
    @Override
    public void onResponse(Call<User> call, Response<User> response) {
        if(response.isSuccessful()){
            id = response.body().getId();
            ((LoginFragment)fragment).userInfo(response.body());
        }
    }

    @Override
    public void onFailure(Call<User> call, Throwable t) {

    }
}
