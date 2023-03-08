package com.example.spring_demo.user.repository;

import com.example.spring_demo.user.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface UserRepository {
    public final static List<User> users = new ArrayList<>(Arrays.asList(
        new User(1, "x@x.pl", "x"),
        new User(2, "y@y.pl", "y"),
        new User(3, "z@z.pl", "z")
    ));
}
