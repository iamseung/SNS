package com.example.sns.service;

import com.example.sns.Entity.User;
import com.example.sns.exception.SnsApplicationException;
import com.example.sns.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // TODO : implement
    public User join(String userName, String password) {
        // UserName 으로 중복 체크
        Optional<User> user = userRepository.findByUserName(userName);

        userRepository.save(new User());
        return new User();
    }

    // TODO : jwt 적용
    public String login(String userName, String password) {
        // 회원가입 여부 체크
        User user = userRepository.findByUserName(userName).orElseThrow(() -> new SnsApplicationException());

        // 비밀번호 체크
        if(user.getPassword().equals(password)) {
            throw new SnsApplicationException();
        }

        // 토큰 생성

        return "";
    }
}
