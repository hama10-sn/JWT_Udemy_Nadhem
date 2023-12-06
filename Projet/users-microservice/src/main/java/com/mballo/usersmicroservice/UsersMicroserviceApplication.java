package com.mballo.usersmicroservice;

import com.mballo.usersmicroservice.entities.Role;
import com.mballo.usersmicroservice.entities.User;
import com.mballo.usersmicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class UsersMicroserviceApplication {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UsersMicroserviceApplication.class, args);
    }


    //	Ajouter quelques users et roles après le démarrage de l'app
   /* @PostConstruct
    void init_users() {
        //ajouter les rôles
        userService.addRole(new Role(null, "ADMIN"));
        userService.addRole(new Role(null, "USER"));

        //ajouter les users
        userService.saveUser(new User(null, "admin", "123", true, null));
        userService.saveUser(new User(null, "mballo", "123", true, null));
        userService.saveUser(new User(null, "maryam", "123", true, null));

        //ajouter les rôles aux users
        userService.addRoleToUser("admin", "ADMIN");
        userService.addRoleToUser("admin", "USER");
        userService.addRoleToUser("mballo", "USER");
        userService.addRoleToUser("maryam", "USER");
    }*/

    @Bean
    public BCryptPasswordEncoder getBEC() {
        return new BCryptPasswordEncoder();
    }
}
