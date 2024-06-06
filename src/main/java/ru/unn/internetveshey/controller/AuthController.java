package ru.unn.internetveshey.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.unn.internetveshey.payload.request.LoginRequest;
import ru.unn.internetveshey.payload.request.SignupRequest;
import ru.unn.internetveshey.payload.response.JwtResponse;
import ru.unn.internetveshey.services.AuthenticationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(LoginRequest loginRequest) {
        return ResponseEntity.ok(authenticationService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(SignupRequest signupRequest) {
        authenticationService.register(signupRequest);
        return ResponseEntity.ok("User registered successfully");
    }
}
