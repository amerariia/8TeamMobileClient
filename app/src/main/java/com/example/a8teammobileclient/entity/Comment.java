package com.example.a8teammobileclient.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Comment {
    String text;
    Post post;
    User sender;
}
