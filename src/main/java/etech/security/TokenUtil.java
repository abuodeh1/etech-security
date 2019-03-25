package etech.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtil {

    private final String CLAIMS_SUBJECT = "sub";
    private final String CLAIMS_CREATED = "created";

    @Value("${jwt.expiration}")
    private Long TOKEN_VALIDITY = 604800L;

    @Value("${jwt.secret}")
    private String SECRET_KEY = "mH6U7DlOO0";

    public String generateToken(UserDetails userDetails){

        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIMS_SUBJECT, userDetails.getUsername());
        claims.put(CLAIMS_CREATED, new Date());

        return Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                    .compact();
    }

    public String getUsernameFromToken(String token){
        try {
            Claims claims = getClaims(token);
            return claims.getSubject();
        }catch(Exception ex){
            return null;
        }
    }

    private Claims getClaims(String token) {
        Claims claims;
        try{
            claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        }catch(Exception ex){
            claims = null;
        }
        return claims;
    }

    public boolean isTokenValid(String token, MyUser myUser) {
        return ( getUsernameFromToken(token).equalsIgnoreCase(myUser.getUsername()) && !isNotExpired(token));
    }

    private boolean isNotExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }
}
