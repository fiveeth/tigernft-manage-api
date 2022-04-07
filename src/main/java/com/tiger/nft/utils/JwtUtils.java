package com.tiger.nft.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Map;

/**
 * jjwt 工具类
 * @author xxx
 */
public class JwtUtils {

    private static final String SECRET_KEY = "tiger-nft";

    /**
     * @param subject
     * @param claims
     * @param ttlMillis 过期毫秒数
     * @return
     */
    public static String createToken(String subject, Map<String, Object> claims, long ttlMillis) {
        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + ttlMillis))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .setId(UuidUtils.uuidNoDash());
        for (Map.Entry<String, Object> claim : claims.entrySet()) {
            builder.claim(claim.getKey(), claim.getValue());
        }
        return builder.compact();
    }

    /**
     * 获取token的payload信息
     *
     * @param token
     * @return
     */
    public static Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}
