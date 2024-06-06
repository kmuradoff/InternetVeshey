package ru.unn.internetveshey.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.unn.internetveshey.config.CommonProperties;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JwtService {
    private static final String ISSUER = "Military";
    private final CommonProperties properties;

    private Algorithm algorithm;
    private JWTVerifier verifier;

    @PostConstruct
    private void init() {
        algorithm = Algorithm.HMAC256(properties.getJwtSigningKey());
        verifier = JWT.require(algorithm)
                .withIssuer(ISSUER)
                .build();
    }

    public String generateToken() {
        return JWT.create()
                .withIssuer(ISSUER)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000L * 60 * 60 *24))
                .withJWTId(UUID.randomUUID().toString())
                .sign(algorithm);
    }


    @SuppressWarnings("unusedThrown")
    public DecodedJWT getDecodedJwt(String jwtToken) {
        return verifier.verify(jwtToken);
    }

    private Map<String, Claim> getAllClaims(DecodedJWT decodedJWT) {
        return decodedJWT.getClaims();
    }
}