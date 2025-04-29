package com.mycom.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mycom.myapp.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(
        @RequestParam(name = "username") String username,
        @RequestParam(name = "password") String password,
        @RequestParam(name = "name") String name,
        @RequestParam(name = "phone") String phone) {

        userService.signup(username, password, name, phone);
        return ResponseEntity.ok("회원가입 성공");
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(
        @RequestParam(name = "username") String username,
        @RequestParam(name = "password") String password) {
        
        boolean isLoggedIn = userService.login(username, password);
        if (isLoggedIn) {
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.status(401).body("아이디 또는 비밀번호가 잘못되었습니다");
        }
    }
}
