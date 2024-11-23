package com.chenemiken.mockbase.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtService {
    @Value("${app.jwt.secret}")
    String jwtSecret;

    public String generateToken(UserDetails userDetails){
        SecretKey secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        return Jwts.builder().subject(userDetails.getUsername()).signWith(secretKey).compact();
    }
}
