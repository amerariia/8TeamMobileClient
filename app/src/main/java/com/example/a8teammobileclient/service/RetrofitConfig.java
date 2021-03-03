package com.example.a8teammobileclient.service;

import lombok.Getter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Getter
public class RetrofitConfig {
    private static final String BASE_URL = "https://grouper-8team-api.herokuapp.com/api";
    private static RetrofitConfig config;

    private FormService formService;
    private GroupService groupService;
    private PostService postService;
    private UserService userService;

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

        formService = retrofit.create(FormService.class);
        groupService = retrofit.create(GroupService.class);
        postService = retrofit.create(PostService.class);
        userService = retrofit.create(UserService.class);

    }
}
