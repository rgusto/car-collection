package com.ricardo.carcollection.domain.service;

import com.ricardo.carcollection.domain.entity.User;
import com.ricardo.carcollection.domain.exception.UserNotFoundException;
import com.ricardo.carcollection.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public void signIn(User user) {
        Optional<User> userDb = userRepository.findById(user.getId());
        if (userDb.isPresent()) {
            user.setLastLoginAt(new Date());
            userRepository.save(user);
        }
    }


}
