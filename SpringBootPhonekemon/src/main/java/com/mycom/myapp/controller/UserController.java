package com.mycom.myapp.controller;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            HttpSession session
    ) {
        Logger logger = LoggerFactory.getLogger(UserController.class);

        boolean isLoggedIn = userService.login(username, password);

        if (isLoggedIn) {
            session.setAttribute("username", username);
            logger.info("로그인 성공: {}", username);

            //  JSON 형태로 반환
            return ResponseEntity.ok("""
            {"result":"success"}
        """);
        } else {
            logger.warn("로그인 실패 (아이디 또는 비번 오류): {}", username);

            return ResponseEntity
                    .status(401)
                    .body("""
                {"result":"fail", "message":"아이디 또는 비밀번호가 잘못되었습니다"}
            """);
        }
    }
}
