package com.mycom.myapp.jwt;

import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

// jwt 생성 검증
@Component
@RequiredArgsConstructor
public class JwtUtil {

    @Value("${myapp.jwt.secret}")
    private String secretKeyStr;
    private SecretKey secretKey;
    private final long tokenValidDuration = 1000L * 60 * 60 * 24;

    @PostConstruct
    private void init() {
        System.out.println(secretKeyStr);
        secretKey = new SecretKeySpec(secretKeyStr.getBytes(StandardCharsets.UTF_8),
                Jwts.SIG.HS256.key().build().getAlgorithm()
        );
        System.out.println(secretKey);
    }
}
