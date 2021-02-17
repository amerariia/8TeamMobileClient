package com.example.a8teammobileclient.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Form {
    Integer id;
    Post post;
    FormContent formContent;
    List<User> users;
}
