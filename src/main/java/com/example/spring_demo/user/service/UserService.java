package com.example.spring_demo.user.service;


import com.example.spring_demo.user.model.User;
import com.example.spring_demo.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service        // klasa specjalna dostarczająca logikę biznesową
public class UserService {

    public List<User> getUsers(){
        return UserRepository.users
                .stream()
                .sorted(Comparator.comparing(User::getEmail).reversed())
                .collect(Collectors.toList());
    }
    private int incrementMaxUserId(){
        return UserRepository.users
                .stream()
                .map(User::getUserId)
                .max(Integer::compareTo)
                .get() + 1;
    }
    public void addUser(String email, String password){
        UserRepository.users.add(new User(incrementMaxUserId(), email, password));
    }
    public boolean deleteUserById(int userId){
        return UserRepository.users
                .stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                    .map(UserRepository.users::remove)
                    .orElse(false);
    }
}
