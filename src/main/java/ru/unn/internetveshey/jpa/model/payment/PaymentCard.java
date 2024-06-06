package ru.unn.internetveshey.jpa.model.payment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.unn.internetveshey.dto.enums.CardBrand;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "payment_card", schema = "internet_veshey")
public class PaymentCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private CardBrand cardBrand;
    private String cardNumber;
    @DateTimeFormat(pattern = "MM/yyyy")
    private Date validThru;
    private String cardHolder;
    private int cvc;
}
