package com.management.laundary.laundary_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.laundary.laundary_management.entity.User;
import com.management.laundary.laundary_management.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User saveUser(User user){
        return userRepository.saveAndFlush(user);
    }
    public User logIn(String email, String password) {
        User user= userRepository.findUserByEmailAndPassword(email,password);
        if(user==null)
            return user;
        user.setPassword("");
        return user;
    }
    public User loadUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
    public String changePassword(String email, String oldPassword, String newPassword) {
        User user=userRepository.findUserByEmailAndPassword(email, oldPassword);
        if(user==null)
            return "Invalid Credential";
        user.setPassword(newPassword);
        userRepository.save(user);
        return "password changed successfully";
    }
    public String changeUserDetails(User user) {
        User userFromDb=userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
        if(userFromDb==null)
            return "Data not found";
        userFromDb.setMobileNumber(user.getMobileNumber());
        userFromDb.setFullName(user.getFullName());
        userRepository.save(userFromDb);
        return "Updated Successfully";
    }
}
