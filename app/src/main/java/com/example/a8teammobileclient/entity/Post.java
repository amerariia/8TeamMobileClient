package com.example.a8teammobileclient.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import retrofit2.http.Body;

@Getter
@Setter
@Builder
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
    List<Form> forms;

    @SerializedName("groupId")
    @Expose
    Integer groupId;

    @SerializedName("acknowledgeUsers")
    @Expose
    List<User> acknowledgeUsers;
}
