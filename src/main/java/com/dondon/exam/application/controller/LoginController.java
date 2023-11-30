package com.dondon.exam.application.controller;

import com.dondon.exam.application.model.User;
import com.dondon.exam.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public ResponseEntity<User> login(){
        return new ResponseEntity<>(service.getUser(), HttpStatus.OK);
    }
}
