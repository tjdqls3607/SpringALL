package com.mycom.myapp.common;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycom.myapp.user.dto.UserDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	private final String jsonStr = "{\"result\":\"login\"}";
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("LoginInterceptor >>>>> " + request.getRequestURI()); // 인터셉터가 항상 동작한다.

		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		
		if( userDto == null ) {
			
			// ajax 요청
			// client 가 header 에 "ajax":"true" <= board.jsp
			// {"result":"login"} json 문자열 응답
			// client 의 javascript 에서 window.location.href 를 이용해서 페이지를 이동시켜야 한다. 
			if( "true".equals(request.getHeader("ajax")) ) {
				System.out.println("LoginInterceptor >>>>> ajax request ");
				response.getWriter().write(jsonStr);
				
			// page 요청
			// => login 페이지로 이동 (redirection)
			} else {
				System.out.println("LoginInterceptor >>>>> page request ");
				response.sendRedirect("/pages/login");
			}
			
			return false;

		}
		return true;
	}
}