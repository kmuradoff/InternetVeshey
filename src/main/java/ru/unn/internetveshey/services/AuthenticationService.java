package ru.unn.internetveshey.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.unn.internetveshey.dto.enums.Role;
import ru.unn.internetveshey.exceptions.BadRequestException;
import ru.unn.internetveshey.exceptions.UnauthorizedException;
import ru.unn.internetveshey.interceptor.HasRole;
import ru.unn.internetveshey.jpa.model.User;
import ru.unn.internetveshey.jpa.repository.UserRepository;
import ru.unn.internetveshey.payload.request.LoginRequest;
import ru.unn.internetveshey.payload.request.SignupRequest;
import ru.unn.internetveshey.payload.response.JwtResponse;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository usersRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public JwtResponse login(LoginRequest loginRequest) {
        User user = usersRepository.findFirstByLoginSafe(loginRequest.getLogin());
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new UnauthorizedException("WRONG_PASSWORD", "Неверный пароль");
        }

        return new JwtResponse(jwtService.generateToken(), user.getRole().getValue());
    }

    public void register(SignupRequest signupRequest) {
        String login = signupRequest.getLogin();
        if (usersRepository.findFirstByLogin(login) != null) {
            throw new BadRequestException("USER_ALREADY_REGISTERED", String.format("Логин %s уже используется", login));
        }

        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());

        User user = User.builder()
                .login(login)
                .password(hashPassword)
                .email(signupRequest.getEmail())
                .phone(signupRequest.getPhone())
                .firstName(signupRequest.getFirstName())
                .lastName(signupRequest.getLastName())
                .middleName(signupRequest.getMiddleName())
                .residenceCountry(signupRequest.getResidenceCountry())
                .driverLicenseNumber(signupRequest.getDriverLicenseNumber())
                .role(signupRequest.getRole())
                .build();

        usersRepository.save(user);
    }
}