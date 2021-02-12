package com.example.a8teammobileclient.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Content {
    String header;
    List<Question> questions;
}
