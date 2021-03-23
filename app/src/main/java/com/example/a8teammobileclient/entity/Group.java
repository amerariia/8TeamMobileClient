package com.example.a8teammobileclient.entity;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Group {
    @SerializedName("id")
    @Expose
    Integer id;

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("identificator")
    @Expose
    String identificator;

    @SerializedName("childGroups")
    @Expose
    List<Group> childGroups;

    @SerializedName("participants")
    @Expose
    List<User> participants;

    @SerializedName("tasks")
    @Expose
    List<Post> tasks;

    @SerializedName("description")
    @Expose
    String description;

    @SerializedName("usefulContent")
    @Expose
    String usefulContent;

    @SerializedName("parentGroupId")
    @Expose
    Integer parentGroupId;
}
