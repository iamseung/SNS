package com.example.sns.controller.response;

import com.example.sns.model.UserRole;
import com.example.sns.model.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserJoinResponse {

    private Integer id;
    private String userName;
    private UserRole userRole;

    public static UserJoinResponse from(UserDto user) {
       return new UserJoinResponse(
               user.getId(),
               user.getUserName(),
               user.getUserRole()
       );
    }
}
