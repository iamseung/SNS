package com.example.sns.service;

import com.example.sns.Entity.User;
import com.example.sns.exception.ErrorCode;
import com.example.sns.exception.SnsApplicationException;
import com.example.sns.model.dto.UserDto;
import com.example.sns.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // TODO : implement
    public UserDto join(String userName, String password) {
        // UserName 으로 중복 체크
        userRepository.findByUserName(userName).ifPresent(it -> {
            throw new SnsApplicationException(ErrorCode.USER_NOT_FOUND, String.format("userName is %s", userName));
        });

        User user = userRepository.save(User.to(userName, password));
        return UserDto.from(user);
    }

    // TODO : jwt 적용
    public String login(String userName, String password) {
        // 회원가입 여부 체크
        User user = userRepository.findByUserName(userName).orElseThrow(() -> new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME, ""));

        // 비밀번호 체크
        if(user.getPassword().equals(password)) {
            throw new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME, "");
        }

        // 토큰 생성

        return "";
    }
}
