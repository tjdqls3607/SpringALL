package com.mycom.myapp.user.dto;

import lombok.Data;

import java.util.List;

@Data
// @Builder 없음.
public class UserResultDto {
	private String result;
	private UserDto userDto;
	private List<UserDto> userList;
}
