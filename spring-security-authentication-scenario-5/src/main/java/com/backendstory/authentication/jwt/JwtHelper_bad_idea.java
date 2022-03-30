package com.backendstory.authentication.jwt;

/*
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;*/
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtHelper_bad_idea {
/*
    private static final int expireInMs = 60 * 1000 * 100;

    //The class that generates the key is created at runtime
    //So, each time the server startups(production pass) the secret key is regenerated
    //In consecuense all displayed JWT´s get obsolete.
    //Because of that, using "io.jsonwebtoken.**" dependency is not a good production ida
    private final static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generate(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("backendstory.com")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expireInMs))

                .signWith(key)
                .compact();
    }

    //DefaultJwtSignatureValidator inner class validates the JWT when the claims are resolved
    public boolean validate(String token) {
        if (getUsername(token) != null && isExpired(token)) {
            return true;
        }
        return false;
    }

    public String getUsername(String token) {
        Claims claims = getClaims(token);
        return claims.getSubject();
    }

    public boolean isExpired(String token) {
        Claims claims = getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }

    private Claims getClaims(String token) {
//        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
    */
}
