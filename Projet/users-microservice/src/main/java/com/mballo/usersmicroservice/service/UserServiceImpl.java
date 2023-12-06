package com.mballo.usersmicroservice.service;

import com.mballo.usersmicroservice.entities.Role;
import com.mballo.usersmicroservice.entities.User;
import com.mballo.usersmicroservice.repository.RoleRepository;
import com.mballo.usersmicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User addRoleToUser(String username, String rolename) {
        User usr = userRepository.findByUsername(username);
        Role myRole = roleRepository.findByRole(rolename);

        usr.getRoles().add(myRole);

//        @Transactional remplace la ligne suivante car elle fait un save après chaque modif
//        userRepository.save(usr);
        return usr;
    }
}
