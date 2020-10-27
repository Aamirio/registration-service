package com.aamir.api.registration.repository;

import com.aamir.api.registration.dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldFindUsers_whenValidUsersAdded() {

        final User user1 = new User("Max", "myPwd", "a@a.com", "01-09-1970", "1234567812345678");
        final User user2 = new User("Taz", "myPwd", "b@b.com", "02-09-1970", "2234567812345678");

        userRepository.save(user1);
        userRepository.save(user2);

        final List<User> allUsers = userRepository.findAll();

        assertThat(allUsers).isNotEmpty();
        assertThat(allUsers.size()).isEqualTo(2);
        assertThat(allUsers.get(0)).isEqualTo(user1);
        assertThat(allUsers.get(1)).isEqualTo(user2);
    }

    @Test
    public void shouldAddUser_whenUserIsValid() {

        final User user = new User("Max", "myPwd", "a@a.com", "01-09-1970", "1234567812345678");

        userRepository.save(user);

        final List<User> allUsers = userRepository.findAll();

        assertThat(allUsers).isNotEmpty();
        assertThat(allUsers.size()).isEqualTo(1);
        assertThat(allUsers.get(0)).isEqualTo(user);
    }

}