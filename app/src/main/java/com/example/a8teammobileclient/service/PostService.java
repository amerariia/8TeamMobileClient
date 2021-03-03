package com.example.a8teammobileclient.service;

import com.example.a8teammobileclient.entity.Post;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface PostService {
    @POST("Post")
    Call<Post> create();

    @GET("Post")
    Call<List<Post>> get();

    @GET("Post/{id}")
    Call<Post> get(@Path("id") Integer id);

    @DELETE("Post/{id}")
    Call<ResponseBody> delete(@Path("id") Integer id);

    @PUT("Post/{id}")
    Call<Post> modify(@Path("id") Integer id);

    @POST("Post/{postId}/add-comment")
    Call<ResponseBody> addComment(@Path("pathId") Integer id);
}
