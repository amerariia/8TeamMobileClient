package com.example.a8teammobileclient.controller.user;

import androidx.fragment.app.Fragment;

import com.example.a8teammobileclient.entity.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserSignUp implements Callback<ResponseModel> {
    private final Fragment fragment;
    public UserSignUp(Fragment fragment){
        this.fragment = fragment;
    }
    @Override
    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

    }

    @Override
    public void onFailure(Call<ResponseModel> call, Throwable t) {

    }
}
