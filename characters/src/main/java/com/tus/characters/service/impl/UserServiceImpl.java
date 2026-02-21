package com.tus.characters.service.impl;

import org.springframework.stereotype.Service;
import com.tus.characters.entity.User;
import com.tus.characters.repository.UserRepository;
import com.tus.characters.service.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found with userId: " + userId));
    }
}