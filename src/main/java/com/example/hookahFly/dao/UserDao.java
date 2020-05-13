package com.example.hookahFly.dao;

import com.example.hookahFly.role.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
