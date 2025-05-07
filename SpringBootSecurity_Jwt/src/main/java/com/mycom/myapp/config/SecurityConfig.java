package com.mycom.myapp.config;

import com.mycom.myapp.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtUtil jwtUtil;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http,
                                  MyAuthenticationeEntryPoint entryPoint
    ) throws Exception {
        return http
                // form login 관련 disable
                .httpBasic(httpBasic -> httpBasic.disable())
                .formLogin(formLogin -> formLogin.disable())
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(
                        request -> {
                            // 위 두개의 경로에 대한 요청은 인증/인가 처리를 하지 않겠다.
                            request.requestMatchers(
                                    "/",
                                    "/index.html",
                                    "/login",
                                    "/login.html",
                                    "/register",
                                    "/register.html",
                                    "/users/**"
                                    ).permitAll()
                                    .requestMatchers("/customer/**").hasAnyRole("ADMIN", "CUSTOMER")
                                    .requestMatchers("/admin/**").hasRole("ADMIN");
                            // 그 외 경로에 대한 요청은 인증이 필요하다.
                            request.anyRequest().authenticated();
                        }
                )
                // formLogin 방식에서 허락되지 않는 요청에 대해 자동으로 login  페이지로 분기
                // formLogin 을 사용 X -> 예외 발생 -> json 응답 -> (login 필요)
                .exceptionHandling(
                        exceptionHandlingCustmoizer ->
                                exceptionHandlingCustmoizer.authenticationEntryPoint(entryPoint))
                // formLogin 방식에서는 Spring Security 가 자동으로 Filter 처리 ( UsernamePasswordAuthenticationFilter)
                // formLogin 을 사용 X -> 위 필터 앞에서 한 번 수행되는 jwt 인증 필터를 적용
//                .addFilterBefore(new JwtAuthenticationFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class)
                .build();
    }


}