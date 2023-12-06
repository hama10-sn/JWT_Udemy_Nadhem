package com.mballo.usersmicroservice.service;

import com.mballo.usersmicroservice.entities.Role;
import com.mballo.usersmicroservice.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    User findUserByUsername(String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);
    List<User> findAllUsers();
}
