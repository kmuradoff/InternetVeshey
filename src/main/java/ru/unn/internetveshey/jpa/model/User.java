package ru.unn.internetveshey.jpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import ru.unn.internetveshey.dto.enums.Country;
import ru.unn.internetveshey.jpa.model.payment.PaymentCard;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "user", schema = "internet_veshey")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    @Email(message = "Email should be valid")
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String middleName;
    private Country residenceCountry;
    private String driverLicenseNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_to_paymentcards", schema = "internet_veshey",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id"))
    private Set<PaymentCard> paymentCards;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    private Set<Ride> rides;


}
