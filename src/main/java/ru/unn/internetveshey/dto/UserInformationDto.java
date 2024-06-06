package ru.unn.internetveshey.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import ru.unn.internetveshey.dto.enums.Country;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInformationDto {
    private String login;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String middleName;
    private Country residenceCountry;
    private String driverLicenseNumber;
}
