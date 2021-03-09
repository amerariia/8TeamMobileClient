package com.example.a8teammobileclient.controller.form;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormDelete implements Callback<ResponseBody> {
    private final AppCompatActivity activity;
    public FormDelete(AppCompatActivity activity){
        this.activity = activity;
    }
    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        if(response.isSuccessful()){
            // TODO send to actiity
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        // TODO send to actiity

    }
}
