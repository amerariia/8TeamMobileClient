package com.example.a8teammobileclient.service;

import com.example.a8teammobileclient.entity.Token;

import java.io.IOException;

import com.example.a8teammobileclient.controller.user.UserSignIn;
import lombok.Getter;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Getter
public class RetrofitConfig {
    private static final String BASE_URL = "https://grouper-8team-api.herokuapp.com/api/";
    private static RetrofitConfig config;
    private static Token TOKEN = Token.builder().token("").build();

    private FormService formService;
    private GroupService groupService;
    private PostService postService;
    private UserService userService;

    public static void trySetToken(Token token){
        TOKEN = token;
    }

    public static RetrofitConfig get(){
        if(config == null){
            config = new RetrofitConfig();
        }
        return config;
    }

    private RetrofitConfig(){
        Retrofit retrofit = new Retrofit.Builder()
                .client(new OkHttpClient.Builder().addInterceptor(chain -> {
                    Request newRequest  = chain.request().newBuilder()
                            .addHeader("Authorization", "Bearer " + RetrofitConfig.TOKEN.getToken())
                            .build();
                    return chain.proceed(newRequest);
                }).build())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        formService = retrofit.create(FormService.class);
        groupService = retrofit.create(GroupService.class);
        postService = retrofit.create(PostService.class);
        userService = retrofit.create(UserService.class);

    }
}
