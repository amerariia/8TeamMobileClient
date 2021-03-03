package com.example.a8teammobileclient.entity;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Group {
    Integer id;
    String name;
    Group parentGroup;
    List<User> pupils;
    List<User> teachers;
    List<Post> posts; //Posts
    List<String> usefulLinks;
}
