package com.mycom.myapp.jwt;

import com.mycom.myapp.config.MyUserDetailsService;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

// jwt 생성 검증
@Component
@RequiredArgsConstructor
public class JwtUtil {

    @Value("${myapp.jwt.secret}")
    private String secretKeyStr;
    private SecretKey secretKey;
    private final long tokenValidDuration = 1000L * 60 * 60 * 24;

    private final MyUserDetailsService myUserDetailsService;

    @PostConstruct
    private void init() {
        System.out.println(secretKeyStr);
        secretKey = new SecretKeySpec(secretKeyStr.getBytes(StandardCharsets.UTF_8),
                Jwts.SIG.HS256.key().build().getAlgorithm()
        );
        System.out.println(secretKey);
    }

    // jwt 생성
    // userName (subjsect), role
    public String createToken(String userName, List<String> roles) {
        // 발급 일자, 만료일자
        Date now = new Date();

        return Jwts.builder()
                .subject(userName)
                .claim("roles", roles)
                .issuedAt(now)
                .expiration(new Date(now.getTime() + tokenValidDuration))
                .signWith(secretKey, Jwts.SIG.HS256)
                .compact();
    }

    // UserDetailsService 를 통해 사용자 인증된 객체
    // 이를 통해서 UsernamePasswordAuthenticationToken 객체를 만들어 리턴
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(this.getUsernameFromToken(token));
        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), "", userDetails.getAuthorities());
    }

    // jwt 로부터 username 추출
    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token).getPayload()
                .getSubject();
    }

    // request 로부터 token 획득
    // client 가 header 에 "X-AUTH-TOKEN"
    public String getTokenFromHeader(HttpServletRequest request) {
        return request.getHeader("X-AUTH-TOKEN");
    }

    // jwt 유효성 검증
    public boolean validateToken(String token) {
       return ! Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token).getPayload()
                .getExpiration().before(new Date());
    }
}
