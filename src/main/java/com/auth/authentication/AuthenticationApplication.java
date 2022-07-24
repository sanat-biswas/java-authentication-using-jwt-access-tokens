package com.auth.authentication;

import com.auth.authentication.domain.Role;
import com.auth.authentication.domain.User;
import com.auth.authentication.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class AuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner runner(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "John", "john", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "John", "john1", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "John", "john12", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "John", "john123", "1234", new ArrayList<>()));

            userService.addRoleToUser("john", "ROLE_USER");
            userService.addRoleToUser("john1", "ROLE_MANAGER");
            userService.addRoleToUser("john12", "ROLE_ADMIN");
            userService.addRoleToUser("john123", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("john123", "ROLE_ADMIN");
            userService.addRoleToUser("john123", "ROLE_MANAGER");
            userService.addRoleToUser("john123", "ROLE_USER");
        };

    }
}

