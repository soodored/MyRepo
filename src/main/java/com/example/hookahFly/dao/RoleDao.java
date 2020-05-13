package com.example.hookahFly.dao;

import com.example.hookahFly.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
