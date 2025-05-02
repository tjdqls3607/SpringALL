package com.mycom.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 요청에 대해서 모두 허락
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(request -> request.anyRequest().permitAll())    // 권한에 대해서 http request를 어떻게 처리할지 (모든요청에 대해서 허가)
//                .build();
//    }

    // 요청에 대해서 모두 인증 받아야됨
    // 로그인 페이지를 통한 인증
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests( request -> request.anyRequest().authenticated() )    // 권한에 대해서 http request를 어떻게 처리할지 (전부다 인증을 받아야함)
//                .formLogin( Customizer.withDefaults() ) // 아무런 설정 없는 경우와 동일
//                .build();
//    }

    //  /,  index.html 모두 허락 나머지는 모두 인증
    // 로그인 페이지를 통한 인증
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                    request -> {
                        request.requestMatchers("/", "/index.html").permitAll()
                                .requestMatchers("/customer/**").hasAnyRole("CUSTIMER", "ADMIN")   // 역할에 따라 접근가능
                                .requestMatchers("/admin/**").hasRole("ADMIN") // ADMIN ROLE 만 접근 가능
                                .anyRequest().authenticated();
                                
                    }
                )    // 권한에 대해서 http request를 어떻게 처리할지 ( /,  index.html 모두 허락 나머지는 모두 인증)
                .formLogin( Customizer.withDefaults() ) // 아무런 설정 없는 경우와 동일
                .build();
    }
}
