package com.t1.api_example.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {
    private final Key key;
    private final Long expirationMillis;

    public JwtService(@Value("${security.jwt.secret}") String secret, @Value("${security.jwt.expiration}") Long expirationMillis){
        if(secret == null || secret.length() < 32){
            throw new IllegalArgumentException("JWT Secret tem que ter pelo menos 32 caracteres");
        }

        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationMillis = expirationMillis;
    }

    public String generateToken(String subject, Map<String, Object> claims){
        Instant now = Instant.now();
        return Jwts.builder()
                .setSubject(subject)
                .addClaims(claims)
                .setIssuedAt(Date.from(now.plusMillis(expirationMillis)))
                .setExpiration(Date.from(now.plusMillis(expirationMillis)))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Jws<Claims> parseToken(String token){
        return Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }

    public String getSubject(String token){
        return parseToken(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try{
            parseToken(token);
            return true;
        }catch (JwtException | IllegalArgumentException e){
            return  false;
        }
    }
}
