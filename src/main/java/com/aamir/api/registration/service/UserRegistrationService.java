package com.aamir.api.registration.service;

import com.aamir.api.registration.dto.User;
import com.aamir.api.registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {

        userRepository.addUser(user);

    }
}
