package com.example.a8teammobileclient.service;

import com.example.a8teammobileclient.entity.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {
    @POST("User/sign-in")
    Call<ResponseBody> signIn();

    @POST("User/sign-up")
    Call<ResponseBody> signUp();

    @GET("User/user-info")
    Call<User> info();
}
