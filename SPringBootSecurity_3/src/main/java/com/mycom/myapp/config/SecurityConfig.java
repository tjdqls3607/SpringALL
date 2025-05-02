package com.mycom.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfig {
//    // 모든 요청에 대한 인가 처리
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(request -> request.anyRequest().permitAll())
//                .build();
//    }

//    // 모든 요청에 대한 인증
//    // 로그인 페이지를 통한 인증
//    // 아무런 설정 없는 경우와 동일
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
//                .formLogin(Customizer.withDefaults())
//                .build();
//    }

    // 모든 요청에 대한 인증
    // /,index.html 모두 허락
    // 로그인 페이지를 통한 인증
    // 아무런 설정 없는 경우와 동일
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        request -> {
                            // 위 두개의 경로에 대한 요청은 인증/인가 처리를 하지 않겠다.
                            request.requestMatchers("/", "/index.html").permitAll()
                                    .requestMatchers("/customer/**").hasAnyRole("ADMIN", "CUSTOMER")
                                    .requestMatchers("/admin/**").hasRole("ADMIN");
                            // 그 외 경로에 대한 요청은 인증이 필요하다.
                            request.anyRequest().authenticated();
                        }
                )

                // csrf 설정
//                .csrf( csrf -> csrf.disable()) 기능 OFF
                .csrf( csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())) // cookie 로 csrf token 을 내려준다.
                .formLogin(
                        form ->
                            form
                                // 사용자정의 login 페이지를 사용하면 기본적으로 csrf 를 전송하도록 구현해야 한다.
                                // 만약 구현하지 않으면 csrf 토큰이 없다는 오류 발생, 로그인 처리 X
                                // csrf 를 무시하도록 설정도 가능
                                .loginPage("/login.html")
                                .defaultSuccessUrl("/", true)
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()) // /logout url로 요청하면 자동으로 Spring Security 가 session 을 invalidate
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}