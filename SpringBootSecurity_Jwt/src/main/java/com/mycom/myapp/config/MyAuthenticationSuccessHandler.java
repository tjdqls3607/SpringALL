package com.mycom.myapp.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication
    ) throws IOException, ServletException {
        // ajax 로그인 성공 결과 리턴
        response.setStatus(HttpServletResponse.SC_OK);  // 200
        response.setContentType("application/json");
        String jsonStr = """
                {"result" : "success"}
                """;
        response.getWriter().print(jsonStr);
    }
}
