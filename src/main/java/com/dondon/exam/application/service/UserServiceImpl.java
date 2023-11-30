package com.dondon.exam.application.service;

import com.dondon.exam.application.model.User;
import com.dondon.exam.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository repository;

    public User getUser(String username) {
        return repository.findByUsername(username);
    }
}
