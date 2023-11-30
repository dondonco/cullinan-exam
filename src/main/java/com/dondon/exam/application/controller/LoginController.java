package com.dondon.exam.application.controller;

import com.dondon.exam.application.model.User;
import com.dondon.exam.application.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserServiceImpl service;

    @GetMapping("/login")
    public ResponseEntity<User> login(@PathVariable String username){
        return new ResponseEntity<>(service.getUser(username), HttpStatus.OK);
    }
}
