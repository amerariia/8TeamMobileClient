package com.example.a8teammobileclient.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {
    Integer id;
    String caption;
    String description;
    List<Comment> comments;
    Group group;
    List<Form> forms; //SentForms
}
