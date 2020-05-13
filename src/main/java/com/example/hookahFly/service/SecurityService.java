package com.example.hookahFly.service;

public interface SecurityService {

    String findByLoggedInUsername();
    void autoloogin(String username, String password);


}
