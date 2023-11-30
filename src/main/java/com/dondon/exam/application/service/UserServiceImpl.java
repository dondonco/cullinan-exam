package com.dondon.exam.application.service;

import com.dondon.exam.application.model.User;
import com.dondon.exam.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User getUser() {
        return null;
    }
}
