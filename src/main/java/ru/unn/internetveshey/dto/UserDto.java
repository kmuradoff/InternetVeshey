package ru.unn.internetveshey.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import ru.unn.internetveshey.dto.enums.Country;
import ru.unn.internetveshey.jpa.model.Ride;
import ru.unn.internetveshey.jpa.model.payment.PaymentCard;

import java.util.Set;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private String login;
    private String password;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String middleName;
    private Country residenceCountry;
    private String driverLicenseNumber;
    private Set<PaymentCard> paymentCards;
    private Set<Ride> rides;
}
