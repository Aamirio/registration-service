package com.aamir.api.registration.service;

import com.aamir.api.registration.dto.User;
import com.aamir.api.registration.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserRegistrationServiceTest {

    @InjectMocks
    private UserRegistrationService userRegistrationService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void shouldRegisterUser_whenUserIsValid() {

        final User user = new User("Max", "myPwd", "a@a.com", "01-09-1970", "1234567812345678");

        userRegistrationService.registerUser(user);

        verify(userRepository, times(1)).save(user);
    }
}