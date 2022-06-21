package com.example.sns.service.user;

import com.example.sns.domain.user.User;
import com.example.sns.dto.user.CreateUserDto;
import com.example.sns.dto.user.SigninDto;

import java.util.Optional;

public interface UserService {
    User createUser(CreateUserDto createUserDto);
    Optional<User> findUserById(Long id);
    User signIn(SigninDto signinDto);
}
