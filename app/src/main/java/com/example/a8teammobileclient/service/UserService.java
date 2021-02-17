package com.example.a8teammobileclient.service;

import com.example.a8teammobileclient.entity.User;
import retrofit2.Call;
import retrofit2.http.POST;

public interface UserService {
    @POST("User/sign-in")
    Call<User> signIn();

    @POST("User/sign-up")
    Call<User> signUp();
}
