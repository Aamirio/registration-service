package com.aamir.api.registration.controller;

import com.aamir.api.registration.dto.User;
import com.aamir.api.registration.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping(path = "/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String registerUser(@RequestBody User user) {

        userRegistrationService.registerUser(user);

        return "User registered successfully";
    }
}
