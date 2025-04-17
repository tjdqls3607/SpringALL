package com.mycom.myapp.auth.service;

import java.util.Optional;

import com.mycom.myapp.user.dto.UserDto;

// LoginResultDto 를 만들지 않고 UserDto 를 return 하는 이유는 Controller 에서 session 처리를 하고 나 뒤에 front 에 응답
public interface LoginService {
	Optional<UserDto> login(UserDto userDto);
	
}
