package com.example.a8teammobileclient.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Form {
    Integer id;
    Task task;
    Content content;
    List<User> users;
}
