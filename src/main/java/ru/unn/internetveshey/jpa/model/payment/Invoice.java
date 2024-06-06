package ru.unn.internetveshey.jpa.model.payment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.unn.internetveshey.dto.enums.Currency;
import ru.unn.internetveshey.jpa.model.Ride;
import ru.unn.internetveshey.jpa.model.User;

@Getter
@Setter
@Entity
@Table(name = "invoice", schema = "internet_veshey")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float amount;
    private Currency currency;
    private boolean isPaid;
    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_card_id",
            referencedColumnName = "id",
            nullable = false)
    private PaymentCard paymentCard;

    @OneToOne(mappedBy = "invoice",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    private Ride ride;
}
