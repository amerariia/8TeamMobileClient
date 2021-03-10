package com.example.a8teammobileclient;

import com.example.a8teammobileclient.entity.Group;
import com.example.a8teammobileclient.entity.Role;
import com.example.a8teammobileclient.entity.User;

import java.util.ArrayList;
import java.util.List;

public class testData {
    public static List<User> users = new ArrayList<User>(){{
       add(User.builder().firstName("studentFN studentSN").role(Role.STUDENT).email("student").password("student").email("student@student.com").build());
       add(User.builder().firstName("teacherFN teacherSN").role(Role.STUDENT).email("teacher").password("teacher").email("teacher@teacher.com").build());
    }};

    public static List<Group> groups = new ArrayList<Group>(){{
        add(Group.builder().name("groupName1").id(1).build());
        add(Group.builder().name("groupName2").id(2).build());
        add(Group.builder().name("groupName3").id(3).build());
        add(Group.builder().name("groupName4").id(4).build());
        add(Group.builder().name("groupName5").id(5).build());
        add(Group.builder().name("groupName6").id(6).build());
        add(Group.builder().name("groupName7").id(7).build());
        add(Group.builder().name("groupName8").id(8).build());
        add(Group.builder().name("groupName9").id(9).build());

    }};
}
