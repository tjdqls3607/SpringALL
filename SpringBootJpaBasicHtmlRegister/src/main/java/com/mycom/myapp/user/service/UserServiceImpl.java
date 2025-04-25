package com.mycom.myapp.user.service;

import org.springframework.stereotype.Service;

import com.mycom.myapp.user.dto.UserResultDto;
import com.mycom.myapp.user.entity.User;

// Register 단계
// UserRepository - save
// UserRoleRepository - find, save
@Service
public class UserServiceImpl implements UserService{

	@Override
	public UserResultDto insertUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
