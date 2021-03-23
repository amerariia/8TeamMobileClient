package com.example.a8teammobileclient.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Comment {
    @SerializedName("id")
    @Expose
    Integer id;

    @SerializedName("text")
    @Expose
    String text;

    @SerializedName("sender")
    @Expose
    User sender;

    @SerializedName("postId")
    @Expose
    Integer postId;
}
