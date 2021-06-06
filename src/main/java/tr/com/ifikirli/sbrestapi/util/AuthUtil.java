package tr.com.ifikirli.sbrestapi.util;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;
import tr.com.ifikirli.sbrestapi.config.JwtProperties;
import tr.com.ifikirli.sbrestapi.exception.TokenException;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

@Component
public class AuthUtil {

    private static final int MAX_SALT_SIZE = 16;
    private static final int COST = 8;

    private final JwtProperties jwtProperties;
    private final Algorithm  algorithm;

    public AuthUtil(JwtProperties jwtProperties) {

        this.jwtProperties = jwtProperties;
        this.algorithm = Algorithm.HMAC256(Base64.getDecoder().decode(jwtProperties.getSecret()));
    }

    public DecodedJWT verifyToken(String token) {

        try {

            JWTVerifier jwtVerifier = getJWTVerifier();
            return jwtVerifier.verify(token);
        } catch (JWTVerificationException jwtVerificationException) {

            throw new TokenException(jwtVerificationException.getMessage());
        }
    }

    private JWTVerifier getJWTVerifier() {
        return JWT.require(algorithm)
                  .withIssuer(jwtProperties.getIssuer())
                  .withAudience(jwtProperties.getKey())
                  .build();
    }

    public static byte[] generateSalt() {

        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[MAX_SALT_SIZE];
        secureRandom.nextBytes(salt);
        return salt;
    }

    public static byte[] generatePassword(String passwordAsPlainText, byte[] salt) {

        return BCrypt.withDefaults().hash(COST, salt, passwordAsPlainText.getBytes(StandardCharsets.UTF_8));
    }

    public String createAccessToken(String username) {

        return createTokenWithJWT(username, jwtProperties.getAccessTokenExpire() * 60000);
    }

    public String createRefreshToken(String username) {

        return createTokenWithJWT(username, jwtProperties.getRefreshTokenExpire() * 60000);
    }

    private String createTokenWithJWT(String username, long accessTime) {

        long currentTime = new Date().getTime();

        return JWT.create().withAudience(jwtProperties.getKey())
                           .withSubject(username)
                           .withIssuer(jwtProperties.getIssuer())
                           .withExpiresAt(new Date(currentTime + accessTime))
                           .sign(algorithm);
    }
}
