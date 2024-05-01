package com.demo.service;

import com.demo.domain.User;
import com.demo.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public  Boolean checkedUser(String userName) {
        return userRepository.existsByUserName(userName);
    }

    public User findByUserName(String login) {
        User user=userRepository.findByUserName(login);
        return user;
    }


}

 