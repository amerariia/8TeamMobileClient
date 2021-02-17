package com.example.a8teammobileclient.entity;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    String id;
    String name;
    String login;
    String email;
    String password;
    Role role;
    List<Group> groups;
    List<Form> forms;
}
