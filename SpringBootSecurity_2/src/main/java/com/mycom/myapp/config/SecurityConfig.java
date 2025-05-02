package com.mycom.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    //  /,  index.html 모두 허락 나머지는 모두 인증
    // 로그인 페이지를 통한 인증
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                    request -> {
                        request.requestMatchers("/", "/index.html").permitAll();
                        request.anyRequest().authenticated();
                    }
                )    // 권한에 대해서 http request를 어떻게 처리할지 ( /,  index.html 모두 허락 나머지는 모두 인증)
                .formLogin( Customizer.withDefaults() ) // 아무런 설정 없는 경우와 동일
                .build();
    }
}
