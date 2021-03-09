package com.example.a8teammobileclient.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
    @SerializedName("id")
    @Expose
    Integer id;

    @SerializedName("caption")
    @Expose
    String caption;

    @SerializedName("description")
    @Expose
    String description;

    @SerializedName("comments")
    @Expose
    List<Comment> comments;

    @SerializedName("forms")
    @Expose
    List<Form> forms; //SentForms
}
