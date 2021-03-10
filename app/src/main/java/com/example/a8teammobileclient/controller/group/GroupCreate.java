package com.example.a8teammobileclient.controller.group;

import androidx.appcompat.app.AppCompatActivity;
import com.example.a8teammobileclient.entity.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupCreate implements Callback<ResponseModel> {
    private final AppCompatActivity activity;
    public GroupCreate(AppCompatActivity activity){
        this.activity = activity;
    }
    @Override
    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

    }

    @Override
    public void onFailure(Call<ResponseModel> call, Throwable t) {

    }
}
