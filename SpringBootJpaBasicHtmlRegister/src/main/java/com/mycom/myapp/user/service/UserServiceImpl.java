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
//		UserRole userRole = userRoleRepository.findByName("ROLE_CUSTOMER");
//		List<UserRole> userRoles = List.of(userRole);
//		user.setUserRoles(userRoles);
//		User savedUser = userRepository.save(user);
		
		
		// #2. 새로운 UserRole 생성
		
		// #2-1 userRole 객체를 save 하지 않음 -> 영속화 X
//		UserRole userRole = new UserRole();
//		userRole.setName("role_test");
//		List<UserRole> userRoles = List.of(userRole);
//		user.setUserRoles(userRoles);
//		User savedUser = userRepository.save(user);
		
		// #2-2 userRole 객체를 save o -> 영속화 o
		UserRole userRole = new UserRole();
		userRole.setName("role_test");
		List<UserRole> userRoles = List.of(userRole);
		user.setUserRoles(userRoles);
		userRoleRepository.save(userRole);	// 위와 다른 부분
		User savedUser = userRepository.save(user);
		
		
		
		userResultDto.setResult("success");
		return userResultDto;
	}

}
