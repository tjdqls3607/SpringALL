package com.mycom.myapp.service;

public interface UserService {
	void signup(String username, String password, String name, String phone);
    boolean login(String username, String password);
}
