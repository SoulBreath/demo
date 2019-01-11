package com.example.demo.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * jwt工具类 用到了@ConfigurationProperties 需要在pom中引入spring-boot-configuration-processor
 * @author xuy
 * @email 756736143@qq.com
 * @date 2018-12-09
 */

@ConfigurationProperties(prefix = "demo.jwt")
@Component
public class JwtUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);

    private long expire;
    private String secret;
    private String header;

    /**
     * 生成jwt token
     */
    public String generateToken(Long userId){
        // token签发时间
        Date nowDate = new Date();
        // 过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);

        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setSubject(userId+"")
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    /**
     * 解析token
     */
    public Claims getClaimByToken(String token){
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            LOGGER.debug("validate is token error ", e);
            return null;
        }
    }

    /**
     * 是否过期
     * @return true 过期
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
