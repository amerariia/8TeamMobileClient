package com.example.a8teammobileclient.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Comment {
    String text;
    Task task;
    User sender;
}
