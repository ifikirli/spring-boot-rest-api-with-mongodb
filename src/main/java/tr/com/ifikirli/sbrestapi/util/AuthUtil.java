package tr.com.ifikirli.sbrestapi.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;
import tr.com.ifikirli.sbrestapi.config.JwtProperties;
import tr.com.ifikirli.sbrestapi.exception.TokenException;

@Component
public class AuthUtil {

    private final JwtProperties jwtProperties;

    private AuthUtil(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    public DecodedJWT verifyToken(String token) {

        try {

            JWTVerifier jwtVerifier = getJWTVerifier();
            return jwtVerifier.verify(token);
        }

        catch (JWTVerificationException jwtVerificationException) {

            throw new TokenException(jwtVerificationException.getMessage());
        }
    }

    private JWTVerifier getJWTVerifier() {
        return JWT.require(Algorithm.HMAC256(jwtProperties.getSecret())).acceptExpiresAt(50).withIssuer(jwtProperties.getIssuer()).withAudience(jwtProperties.getSecret()).build();
    }
}
