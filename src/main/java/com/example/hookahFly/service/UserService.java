package com.example.hookahFly.service;


import com.example.hookahFly.role.User;

public interface UserService {


    void save(User user);

    User findByUsername(String username);

}
