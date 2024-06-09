package com.chenemiken.springreactjwt.utils;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtService {
    public String generateToken(UserDetails userDetails){
        return Jwts.builder().compact();
    }
}
