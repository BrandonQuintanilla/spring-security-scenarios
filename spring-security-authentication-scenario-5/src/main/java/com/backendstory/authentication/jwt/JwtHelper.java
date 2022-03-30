package com.backendstory.authentication.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.stereotype.Service;

@Service
public class JwtHelper {

    //private final static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    /*
    you must use a secret key which has the same (or larger) bit length as the size of the output hash.
    This is to avoid weakening the security strength of the authentication code (see NIST recomendations NIST SP 800-117).
    For example, when using HMAC256, the secret key length must be a minimum of 256 bits.
    * */
    //your-256-bit-secret -> https://www.allkeysgenerator.com/Random/Security-Encryption-Key-Generator.aspx
    private static final String SECRET_KEY = "p3s6v9y$B&E)H@McQfTjWmZq4t7w!z%C";
    private static final String ISSUER = "Brandon Quintanilla";
    private static final Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

    public String generate(String username) {
        String token = null;

        try {
            token = JWT.create()
                    .withClaim("user", username)
                    .withIssuer(ISSUER)
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            //Invalid Signing configuration / Couldn't convert Claims.
        }

        return token;
    }

    public boolean validate(String token) {

        try {

            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
        } catch (JWTVerificationException exception) {
            //Invalid signature/claims
            System.out.println(exception.getMessage());
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    public String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaims().get("user").asString();
        } catch (JWTDecodeException exception) {
            //Invalid token
        }
        return null;
    }
}
