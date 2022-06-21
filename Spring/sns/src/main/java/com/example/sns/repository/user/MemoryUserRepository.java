package com.example.sns.repository.user;

import com.example.sns.domain.user.User;
import com.example.sns.dto.user.CreateUserDto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryUserRepository implements UserRepository{
    private static Map<Long, User> db = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public User save(CreateUserDto createUserDto) {
        User user = new User();
        user.setId(++sequence);
        user.setName(createUserDto.getName());
        user.setProfileImg(createUserDto.getProfileImg());
        user.setLoginId(createUserDto.getLoginId());
        user.setPassword(createUserDto.getPassword());

        db.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public Optional<User> findByLoginId(String loginId) {
        return db.values()
                .stream()
                .filter(user -> user.getLoginId().equals(loginId))
                .findAny();
    }
}
