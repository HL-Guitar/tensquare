package com.tensquare.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * ClassName: ParseJwtTest
 *
 * @Author: Light
 * @Date: 2019/6/6 21:23
 * Description:
 */

public class ParseJwtTest {
    public static void main(String[] args) {
        String token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE1NTk4MjgyODcsImV4cCI6MTU1OTgyODM0Nywicm9sZSI6ImFkbWluIn0.3pZLrgeSZ2yJBAEJJj838Q-ZJNfoeL7YfGSvUKQhIjs";
        Claims claims =
                Jwts.parser().setSigningKey("itcast").parseClaimsJws(token).getBody();
        System.out.println("id:"+claims.getId());
        System.out.println("subject:"+claims.getSubject());
        System.out.println("IssuedAt:"+claims.getIssuedAt());
        System.out.println("getExpiration:"+claims.getExpiration());
        System.out.println("getExpiration:"+claims.get("role"));

    }
}
