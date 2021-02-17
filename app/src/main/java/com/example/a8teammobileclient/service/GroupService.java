package com.example.a8teammobileclient.service;

import com.example.a8teammobileclient.entity.Group;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface GroupService {
    @GET("Group")
    Call<List<Group>> get();

    @POST("Group")
    Call<ResponseBody> create();

    @GET("Group/{id}")
    Call<Group> get(@Path("id") Integer id);

    @DELETE("Group/{id}")
    Call<ResponseBody> delete(@Path("id") Integer id);

    @PUT("Group/{id}")
    Call<ResponseBody> modify(@Path("id") Integer id);

    @POST("Group/{groupId}/add-user")
    Call<ResponseBody> addUser(@Path("groupId") Integer id);

    @POST("Group/{groupId}/add-links")
    Call<ResponseBody> addLinks(@Path("groupId") Integer id);

    // TODO add posts
}
