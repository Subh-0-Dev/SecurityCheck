package com.subh.SecurityCheck.service;

import com.subh.SecurityCheck.Entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    private String secretkey=null;

    public String generateToken(User user){
        Map<String,Object> claims=new HashMap<>();
    return Jwts
            .builder()
            .claims()
            .add(claims)
            .subject(user.getUsername())
            .issuer("DCB")
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + 60*10*1000))
            .and()
            .signWith(generateKey())
            .compact();
    }

    public SecretKey generateKey(){
        byte[] decode = Decoders.BASE64.decode(getSecretkey());
        return Keys.hmacShaKeyFor(decode);

    }

    public String getSecretkey() {
        return secretkey="lgfr1mnGZQUBYmIc1AyswtKkPlnWNeERYlfbr4ajt+I=";
    }

    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    public boolean isTokenValid(String jwt, UserDetails userDetails) {
        return true;
    }
}
