package com.practise.service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64;

public class JWTService {
    private final SecretKey secretKey;

    public JWTService() {
        // Generate a secure key
        this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (60 * 60 * 30 * 1000))) // 30 hours expiry
                .signWith(secretKey) // Use generated key
                .compact();
    }

    public Key getKey() {
        return secretKey;
    }

    public String getEncodedKey() {
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }
}
