package com.example.spring_demo.user.controller;

import com.example.spring_demo.user.model.User;
import com.example.spring_demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController     // klasa specjalna do mapowania żądań protokołu http
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping("/add_user")
    public void addUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ){
        userService.addUser(email, password);
    }
    @DeleteMapping("/{user_id}")
    public boolean deleteUserById(
            @PathVariable("user_id") int userId
    ){
         return userService.deleteUserById(userId);
    }
    @PutMapping("/update_password/{email}")
    public void resetUserPasswordByEmail(
            @PathVariable("email") String email,
            @RequestBody String password
    ){
        userService.resetUserPasswordByEmail(email, password);
    }
}
