package com.example.a8teammobileclient.service;

import lombok.Getter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// TODO create services objects
@Getter
public class RetrofitConfig {
    private static final String BASE_URL = "http://path/to/site";
    private static RetrofitConfig config;

    public static RetrofitConfig get(){
        if(config == null){
            config = new RetrofitConfig();
        }
        return config;
    }

    private RetrofitConfig(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
