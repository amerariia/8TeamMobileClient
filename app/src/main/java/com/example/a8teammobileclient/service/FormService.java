package com.example.a8teammobileclient.service;

import com.example.a8teammobileclient.entity.Form;
import com.example.a8teammobileclient.entity.ResponseModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface FormService {
    @GET("Form/{id}")
    Call<Form> get(@Path("id") Integer id);

    @DELETE("Form/{id}")
    Call<ResponseModel> delete(@Path("id") Integer id);

    @PUT("Form")
    Call<ResponseModel> modify(@Body Form form);

    @GET("Form")
    Call<List<Form>> getAll(@Query("userId") String userId);

    @POST("Form")
    Call<ResponseModel> create(@Body Form form, @Header("Authorization") String token);
}
