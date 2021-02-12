package com.example.a8teammobileclient.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Group {
    Integer id;
    String name;
    Group parentGroup;
    List<User> pupils;
    List<User> teachers;
    List<Task> tasks; //Posts
    List<String> usefulLinks;
}
