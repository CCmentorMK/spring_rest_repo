package com.example.spring_demo.user.service;


import com.example.spring_demo.role.model.RoleType;
import com.example.spring_demo.role.repository.RoleRepository;
import com.example.spring_demo.user.model.User;
import com.example.spring_demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service        // klasa specjalna dostarczająca logikę biznesową
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll(Sort.by(Sort.Direction.ASC,"email"));   // SELECT * FROM users ORDER BY email ASC;
    }

    public void addUser(String email, String password){
        User user = new User(email,password);
        // how to add role to user???
        user.setRoles(new HashSet<>(Arrays.asList(roleRepository.findFirstByRoleTypeJPQL(RoleType.USER).get())));
        userRepository.save(user);                                  // INSERT INTO users VALUES (?,?,?,...);
    }
    public Optional<User> getUserById(int userId){                                      // SELECT * FROM users WHERE user_id = ?
        return userRepository.findById(userId);
    }
    public Optional<User> getUserByEmail(String email){                                      // SELECT * FROM users WHERE email = ?
        return userRepository.findUserByEmail(email);
    }
    public void resetUserPasswordByEmail(String email, String password){
        if(getUserByEmail(email).isPresent()){
            User updatedUser = getUserByEmail(email).get();
            updatedUser.setPassword(password);
            userRepository.save(updatedUser);
        }
    }
    public boolean deleteUserById(int userId){                                          // DELETE FROM users WHERE user_id = ?
        if(getUserById(userId).isPresent()){
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
