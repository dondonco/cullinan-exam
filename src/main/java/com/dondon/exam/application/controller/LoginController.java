package com.dondon.exam.application.controller;

import com.dondon.exam.application.exception.InvalidCredentials;
import com.dondon.exam.application.model.User;
import com.dondon.exam.application.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService service;

    @GetMapping(path = "/login")
    public ResponseEntity<User> login(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        return new ResponseEntity<>(service.getUser(header) , HttpStatus.OK);
    }
}
