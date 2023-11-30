package com.dondon.exam.application.service;

import com.dondon.exam.application.exception.InvalidCredentials;
import com.dondon.exam.application.model.User;
import com.dondon.exam.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User getUser(String header) {
        String credentials = decodeBase64String(header);
        int split = credentials.indexOf(":");

        String username = credentials.substring(0, split);
        String password = toMD5(credentials.substring(split + 1, credentials.length()));

        return repository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new InvalidCredentials("Login Failed!"));
    }

    private String decodeBase64String(String encodedString) {
        String base64EncodedString = encodedString.substring(6);
        byte[] decodedBase64InBytes = Base64.getDecoder().decode(base64EncodedString);
        return new String(decodedBase64InBytes, StandardCharsets.UTF_8);
    }
    private String toMD5(String password) {
        StringBuilder build = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());

            for (byte b : messageDigest) {
                build.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return build.toString();
    }
}
