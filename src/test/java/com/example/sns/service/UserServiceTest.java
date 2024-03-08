package com.example.sns.service;

import com.example.sns.Entity.User;
import com.example.sns.exception.SnsApplicationException;
import com.example.sns.fixture.UserFixture;
import com.example.sns.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void 회원가입이_정상적으로_동작() {
        String userName = "username";
        String password = "password";

        // mocking
        when(userRepository.findByUserName(userName)).thenReturn(Optional.empty());
        when(userRepository.save(any())).thenReturn(Optional.of(UserFixture.get(userName, password)));

        Assertions.assertDoesNotThrow(() -> userService.join(userName, password));
    }

    @Test
    void 회원가입시_userName으로_회원가입한_회원이_없는_경우() {
        String userName = "username";
        String password = "password";

        User fixture = UserFixture.get(userName, password);

        // mocking
        when(userRepository.findByUserName(userName)).thenReturn(Optional.of(fixture));
        when(userRepository.save(any())).thenReturn(Optional.of(fixture));

        Assertions.assertThrows(SnsApplicationException.class, () -> userService.join(userName, password));
    }

    @Test
    void 로그인이_정상적으로_동작() {
        String userName = "username";
        String password = "password";

        User fixture = UserFixture.get(userName, password);

        // mocking
        when(userRepository.findByUserName(userName)).thenReturn(Optional.of(fixture));
        Assertions.assertDoesNotThrow(() -> userService.login(userName, password));
    }

    @Test
    void 로그인시_userName으로_회원가입한_회원이_없는_경우() {
        String userName = "username";
        String password = "password";

        // mocking
        when(userRepository.findByUserName(userName)).thenReturn(Optional.empty());

        Assertions.assertThrows(SnsApplicationException.class, () -> userService.login(userName, password));
    }

    @Test
    void 로그인시_패스워드가_틀린_경우() {
        String userName = "username";
        String password = "password";
        String wrongPassword = "wrongPassword";

        User fixture = UserFixture.get(userName, password);

        // mocking
        when(userRepository.findByUserName(userName)).thenReturn(Optional.of(fixture));

        Assertions.assertThrows(SnsApplicationException.class, () -> userService.login(userName, wrongPassword));
    }
}