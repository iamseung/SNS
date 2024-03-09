package com.example.sns.model.dto;

import com.example.sns.Entity.User;
import com.example.sns.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
public class UserDto {
    private Integer id;
    private String userName;
    private String password;
    private UserRole userRole;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static UserDto from(User user) {
        return new UserDto(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getRole(),
                user.getRegisteredAt(),
                user.getUpdatedAt(),
                user.getRemovedAt()
        );
    }
}
