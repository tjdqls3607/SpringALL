package com.mycom.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class PageController {

    @GetMapping("/board")
    public String board() {
        return "/board.html";
    }
}
