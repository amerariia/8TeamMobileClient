package com.example.a8teammobileclient.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Form {
    @SerializedName("id")
    @Expose
    Integer id;

    @SerializedName("content")
    @Expose
    String content;

    @SerializedName("user")
    @Expose
    User user;

    @SerializedName("postId")
    @Expose
    Integer postId;
}
