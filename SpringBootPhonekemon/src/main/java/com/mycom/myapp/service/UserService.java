package com.mycom.myapp.service;

import com.mycom.myapp.user.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> login(String email, String plainPassword);
    User register(User user);
}
