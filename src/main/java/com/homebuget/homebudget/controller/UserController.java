package com.homebuget.homebudget.controller;

import com.homebuget.homebudget.entity.User;
import com.homebuget.homebudget.repository.UserRepository;
import com.homebuget.homebudget.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {


    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<String> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User - " + user.getId() + " created successfully\n");
    }

}
