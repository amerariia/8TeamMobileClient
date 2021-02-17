package com.example.a8teammobileclient.service;

import com.example.a8teammobileclient.entity.Form;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface FormService {
    @GET("Form/{id}")
    Call<Form> get(@Path("id") Integer id);

    @DELETE("Form/{id}")
    Call<ResponseBody> delete(@Path("id") Integer id);

    @PUT("Form/{id]")
    Call<ResponseBody> modify(@Path("id") Integer id);

    @GET("Form")
    Call<List<Form>> get();

    @POST("Form")
    void create(Form form);
}
