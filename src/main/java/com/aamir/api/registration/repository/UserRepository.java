package com.aamir.api.registration.repository;

import com.aamir.api.registration.dto.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    private final static Map<String, User> allUsers = new HashMap<>();

    public void save(User user) {
        allUsers.put(user.toString(), user);
    }

    public List<User> findAll() {
        return new ArrayList<>(allUsers.values());
    }
}
