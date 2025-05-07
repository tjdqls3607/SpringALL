package com.mycom.myapp.user.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class PageController {

    @GetMapping("/board")
    public String board() {
        return "/board.html";
    }

    @GetMapping("/register")
    public String register() {
        return "/register.html";
    }
}
