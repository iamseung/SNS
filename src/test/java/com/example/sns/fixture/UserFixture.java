package com.example.sns.fixture;

import com.example.sns.Entity.User;

public class UserFixture {

    public static User get(String userName, String password) {
        User user = new User();
        user.setId(1);
        user.setUserName(userName);
        user.setPassword(password);

        return user;
    }
}
