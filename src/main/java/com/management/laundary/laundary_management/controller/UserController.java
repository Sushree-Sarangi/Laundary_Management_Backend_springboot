package com.management.laundary.laundary_management.controller;
import com.management.laundary.laundary_management.entity.User;
import com.management.laundary.laundary_management.service.UserService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/signIn")
    private ResponseEntity<User> userSignIn(@RequestBody User user){
        return ResponseEntity.ok(userService.saveUser(user));
    }
    @PostMapping("/login")
    private User login(@RequestBody Map<String,String> map){
        String email=map.get("email");
        String password=map.get("password");
        return userService.logIn(email,password);
    }
    @PostMapping("/getUserDetails")
    public User getUserDetails(@RequestBody Map<String,String> map){
        String email=map.get("email");
        return userService.loadUserByEmail(email);
    }
    @PostMapping("/changePassword")
    public String changePassword(@RequestBody Map<String,String> map){
        String oldPassword=map.get("oldPassword");
        String newPassword=map.get("newPassword");
        String email=map.get("email");
        return userService.changePassword(email,oldPassword,newPassword);
    }
    @PutMapping("/changeUserDetails")
    public String changeUserDetail(@RequestBody User user){
        return userService.changeUserDetails(user);
    }
}
