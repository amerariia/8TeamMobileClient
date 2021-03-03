package com.example.a8teammobileclient.service;

import com.example.a8teammobileclient.entity.Group;
import com.example.a8teammobileclient.entity.ResponseModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface GroupService {
    @GET("Group")
    Call<List<Group>> get();

    @POST("Group")
    Call<ResponseModel> create(@Body Group group);

    @GET("Group/{id}")
    Call<Group> get(@Path("id") Integer id);

    @DELETE("Group/{id}")
    Call<ResponseModel> delete(@Path("id") Integer id);

    @PUT("Group")
    Call<ResponseModel> modify(@Body Group group);

    @POST("Group/{groupId}/add-user")
    Call<ResponseModel> addUser(@Path("groupId") Integer groupId, @Query("userId") Integer userId);

    @POST("Group/{groupId}/add-links")
    Call<ResponseBody> addLinks(@Path("groupId") Integer id, @Body String link);
}
