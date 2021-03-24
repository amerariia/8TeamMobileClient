package com.example.a8teammobileclient.service;

import com.example.a8teammobileclient.entity.Comment;
import com.example.a8teammobileclient.entity.Post;
import com.example.a8teammobileclient.entity.ResponseModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface PostService {
    @POST("Post")
    Call<ResponseModel> create(@Body Post post);

    @GET("Post")
    Call<List<Post>> getAll(@Query("groupId") Integer groupId);

    @GET("Post/{id}")
    Call<Post> get(@Path("id") Integer id);

    @DELETE("Post/{id}")
    Call<ResponseModel> delete(@Path("id") Integer id);

    @PUT("Post")
    Call<ResponseModel> modify(@Body Post post);

    @POST("Post/add-comment")
    Call<ResponseModel> addComment(@Body Comment comment);
}
