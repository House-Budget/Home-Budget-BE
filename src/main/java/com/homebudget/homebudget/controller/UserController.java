package com.homebudget.homebudget.controller;

import com.homebudget.homebudget.service.UserService;
import com.homebudget.homebudget.entity.User;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("user/{id}")
    public User getUserById(@PathVariable("id") long id) throws Exception{
        return this.userService.getUserById(id);
    }


}
