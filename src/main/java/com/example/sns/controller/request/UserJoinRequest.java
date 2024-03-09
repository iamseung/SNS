package com.example.sns.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class UserJoinRequest {

    private String userName;
    private String password;

    public UserJoinRequest() {

    }

    public UserJoinRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
