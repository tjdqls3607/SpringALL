package com.mycom.myapp.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.myapp.user.dto.UserResultDto;
import com.mycom.myapp.user.entity.User;
import com.mycom.myapp.user.entity.UserRole;
import com.mycom.myapp.user.repository.UserRepository;
import com.mycom.myapp.user.repository.UserRoleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// Register 단계
// UserRepository - save
// UserRoleRepository - find, save
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	private final UserRoleRepository userRoleRepository;
	

	
	@Override
	public UserResultDto insertUser(User user) {
		UserResultDto userResultDto = new UserResultDto();
		
		// #1 기존 UserRole 을 find, name = ROLE_CUSTOMER
		UserRole userRole = userRoleRepository.findByName("ROLE_CUSTOMER");
		List<UserRole> userRoles = List.of(userRole);
		user.setUserRoles(userRoles);
		User savedUser = userRepository.save(user);
		
		userResultDto.setResult("success");
		return userResultDto;
	}

}
