package com.aamir.api.registration.controller;

import com.aamir.api.registration.dto.User;
import com.aamir.api.registration.service.UserRegistrationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserRegistrationControllerTest {

    private final static String PATH = "/registration";

    private MockMvc mockMvc;

    @InjectMocks
    private UserRegistrationController userRegistrationController;

    @Mock
    private UserRegistrationService userRegistrationService;

    @BeforeEach
    private void setup() {
         mockMvc = MockMvcBuilders.standaloneSetup(userRegistrationController).build();
    }

    @Test
    public void shouldRegisterUserSuccessfully_whenUserIsValid() throws Exception {

        final User user = new User("Max", "myPwd", "a@a.com", "01-09-1970", "1234567812345678");
        final String response = mockMvc
                .perform(MockMvcRequestBuilders.post(PATH).contentType(MediaType.APPLICATION_JSON).content(getJsonValue(user)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        verify(userRegistrationService, times(1)).registerUser(user);
        assertThat(response).isEqualTo("User registered successfully");
    }

    private String getJsonValue(Object obj) throws JsonProcessingException {
        return  new ObjectMapper().writeValueAsString(obj);
    }
}