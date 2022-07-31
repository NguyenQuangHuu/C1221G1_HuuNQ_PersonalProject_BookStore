package vn.codegym.book.utils;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.SignatureException;
import java.util.Date;

@Component
public class JwtUtils {
    private final String secretKey = "vn.CodeGym.bookStore.Online";
    private final Integer expiredTokenMs = 360000;
    private final Integer expiredRefreshTokenMs = 3600000;
    Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    public String generateToken(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        return Jwts.builder().setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expiredTokenMs))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

//    public String refreshToken(Authentication authentication){
//        User user = (User) authentication.getPrincipal();
//        return Jwts.builder()
//                .setSubject(user.getUsername())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(new Date().getTime()+expiredRefreshTokenMs))
//                .signWith(SignatureAlgorithm.HS512, secretKey)
//                .compact();
//    }

    public String getUsernameFromToken(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken){
        try{
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e){
            logger.error("Invalid JWT Token: {}",e.getMessage());
        } catch (ExpiredJwtException e){
            logger.error("JWT token is expired: {}",e.getMessage());
        } catch (UnsupportedJwtException e){
            logger.error("JWT token is unsupported: {}",e.getMessage());
        } catch (IllegalArgumentException e){
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
}
