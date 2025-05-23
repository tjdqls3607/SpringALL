package com.mycom.myapp.controller;

import com.mycom.myapp.service.SlackApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SlackApiController {

    private final SlackApiService slackApiService;

   @GetMapping("/notify")
    public String sendSlackMessage() {
       slackApiService.sendMessage("Hello Slack First Message");
       return "Hello Slack First Message";
   }
}
