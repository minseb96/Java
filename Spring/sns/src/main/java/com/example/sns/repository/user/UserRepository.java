package com.example.sns.repository.user;

import com.example.sns.domain.user.User;
import com.example.sns.dto.user.CreateUserDto;

import java.util.Optional;

public interface UserRepository {
    User save(CreateUserDto createUserDto);
    Optional<User> findById(Long id);
}