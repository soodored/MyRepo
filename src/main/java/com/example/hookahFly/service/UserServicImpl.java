package com.example.hookahFly.service;


import com.example.hookahFly.dao.RoleDao;
import com.example.hookahFly.dao.UserDao;
import com.example.hookahFly.role.Role;
import com.example.hookahFly.role.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class UserServicImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(User user) {
        user.getPassword();
    user.setPassword(passwordEncoder.encode(user.getPassword()));//code pass
    Set<Role> roles = new HashSet<>();//get role
    roles.add(roleDao.getOne(1L));
    user.setRoles(roles);
    }

    @Override
    public User findByUsername(String username) {

        return userDao.findByUsername(username);
    }

}
