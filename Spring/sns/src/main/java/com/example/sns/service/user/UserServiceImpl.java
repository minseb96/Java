package com.example.sns.service.user;

import com.example.sns.domain.user.User;
import com.example.sns.dto.user.CreateUserDto;
import com.example.sns.dto.user.SigninDto;
import com.example.sns.repository.user.UserRepository;

import java.util.Optional;

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    //생성자 1개면 자동 autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(CreateUserDto createUserDto) {
        return userRepository.save(createUserDto);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User signIn(SigninDto signinDto) {
        return userRepository.findByLoginId(signinDto.getLoginId())
                .filter(user -> user.getPassword().equals(signinDto.getPassword()))
                .orElse(null);
    }
}
