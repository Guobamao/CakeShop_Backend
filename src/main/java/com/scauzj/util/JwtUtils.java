package com.scauzj.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static final String signKey = "scauzj";
    private static final Long expiration = 43200000L; // 12小时
    /**
     * 生成JWT
     * @param claims
     * @return
     */
    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .compact();
    }


    /**
     * 解析JWT
     * @param jwt
     * @return
     */
    public static Claims parseJwt(String jwt) {

        return Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}