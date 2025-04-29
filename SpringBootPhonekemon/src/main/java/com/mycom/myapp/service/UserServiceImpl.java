package com.mycom.myapp.service;

import org.springframework.stereotype.Service;

import com.mycom.myapp.entity.User;
import com.mycom.myapp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void signup(String username, String password, String name, String phone) {
        if (userRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setPhone(phone);
        userRepository.save(user);
    }

    @Override
    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
