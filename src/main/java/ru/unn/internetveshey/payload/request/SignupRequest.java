package ru.unn.internetveshey.payload.request;

import lombok.Getter;
import lombok.Setter;
import ru.unn.internetveshey.dto.enums.Country;
import ru.unn.internetveshey.dto.enums.Role;

@Getter
@Setter
public class SignupRequest {
    private String login;
    private String password;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String middleName;
    private Country residenceCountry;
    private String driverLicenseNumber;
    private Role role;
}