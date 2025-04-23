package com.mycom.myapp.auth.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.auth.service.LoginService;
import com.mycom.myapp.user.dto.UserDto;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class LoginController {
	
	private final LoginService loginService;
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	// LoginResultDto 대신 Map<String, String> 사용
	// 로그인 성송기 session 에 userDto 를 저장.
	@PostMapping("/login")
	@ResponseBody
	public Map<String, String> login(UserDto userDto, HttpSession session) {
		Map<String, String> map = new HashMap<>();
		
		Optional<UserDto> optional = loginService.login(userDto);
		
		if (optional.isPresent()) {
			UserDto dto = optional.get();
			session.setAttribute("userDto", dto);
			
			map.put("result", "success");
			return map;
		}
		
		// 로그인 실패
		map.put("result", "fail");
		return map;
	}
}
