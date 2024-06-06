package ru.unn.internetveshey.services;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationValidatorService {
    public static final String BEARER_PREFIX = "Bearer ";
    public static final String HEADER_NAME = "Authorization";

    private final JwtService jwtService;

    private DecodedJWT getJwtToken(HttpServletRequest request) {
        String authHeader = request.getHeader(HEADER_NAME);
        if (authHeader == null) {
            return null;
        }
        String jwt = authHeader.substring(BEARER_PREFIX.length());
        try {
            return jwtService.getDecodedJwt(jwt);
        } catch (JWTVerificationException e) {
            return null;
        }
    }
}