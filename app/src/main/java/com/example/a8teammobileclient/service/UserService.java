package com.example.a8teammobileclient.service;

import com.example.a8teammobileclient.entity.ResponseModel;
import com.example.a8teammobileclient.entity.Token;
import com.example.a8teammobileclient.entity.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserService {
    @POST("User/sign-in")
    Call<Token> signIn(@Body User user);

    @POST("User/sign-up")
    Call<ResponseModel> signUp(@Body User user);

    @GET("User/user-info")
    Call<User> info();
}
