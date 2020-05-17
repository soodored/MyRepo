package com.example.hookahFly.service;


import com.example.hookahFly.dao.UserDao;
import com.example.hookahFly.role.Role;
import com.example.hookahFly.role.RoleEnum;
import com.example.hookahFly.role.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        // с помощью нашего сервиса UserService получаем User
        // указываем роли для этого пользователя
        Set<GrantedAuthority> roles = new HashSet();

//        for (Role role: user.getRoles()) {
//            roles.add(new SimpleGrantedAuthority(role.getName().name()));
//        }

        roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        // на основании полученных данных формируем объект UserDetails
        // который позволит проверить введенный пользователем логин и пароль
        // и уже потом аутентифицировать пользователя
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getUsername(),
                        user.getPassword(),
                        roles);

        return userDetails;
    }
}
