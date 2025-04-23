package com.mycom.myapp.auth.service;

import org.springframework.stereotype.Service;

import com.mycom.myapp.user.dto.UserResultDto;
import com.mycom.myapp.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

	private final UserRepository userRepository;
	@Override
	public UserResultDto login(String email, String password) {

		UserResultDto userResultDto = new UserResultDto(); 
		
		return null;
	}

}
