package com.example.sns.service;

import com.example.sns.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // TODO : implement
    public User join() {
        return new User();
    }

    // TODO : jwt 적용
    public String login() {
        return "";
    }
}
