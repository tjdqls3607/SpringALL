package com.mycom.myapp.service;

public interface SlackApiService {
    void sendMessage(String message);
    void sendMessageChannel(String channel, String message);
}
