package com.aamir.api.registration.dto;

import lombok.*;

import java.io.Serializable;

@Value
public class User implements Serializable {

    private final String username;
    private final String password;
    private final String email;
    private final String dob;
    private final String creditCardNumber;

}
