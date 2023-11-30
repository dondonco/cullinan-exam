package com.dondon.exam.application.service;

import com.dondon.exam.application.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User getUser();
}
