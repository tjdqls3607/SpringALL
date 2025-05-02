package com.mycom.myapp.user.dto;

import java.util.List;
import java.util.Map;

import com.mycom.myapp.user.entity.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
public class UserDto {

	private Long id;
	private String name;
	private String email;
	private String password;
	
	private List<UserRole> roles;
}
