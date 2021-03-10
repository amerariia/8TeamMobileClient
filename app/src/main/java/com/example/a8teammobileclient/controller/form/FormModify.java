package com.example.a8teammobileclient.controller.form;

import androidx.appcompat.app.AppCompatActivity;
import com.example.a8teammobileclient.entity.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormModify implements Callback<ResponseModel> {
    private final AppCompatActivity activity;
    public FormModify(AppCompatActivity activity){
        this.activity = activity;
    }
    @Override
    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
        if(response.isSuccessful()){
            ResponseModel form = response.body();
            // TODO send to actiity
        }
    }

    @Override
    public void onFailure(Call<ResponseModel> call, Throwable t) {
        // TODO send to actiity
    }
}
