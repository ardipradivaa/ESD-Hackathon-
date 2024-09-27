package com.domain.ecomeal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.domain.ecomeal.models.entities.MyUser;
import com.domain.ecomeal.repos.MyUserRepo;


@RestController
public class RegistrationController {

    @Autowired
    private MyUserRepo myUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register/user")
    public MyUser createUser(@RequestBody MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("register page");
        return myUserRepository.save(user);
    }
}