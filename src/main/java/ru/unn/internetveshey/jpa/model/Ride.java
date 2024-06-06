package ru.unn.internetveshey.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.unn.internetveshey.jpa.model.payment.Invoice;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "ride", schema = "internet_veshey")
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime endTime;
    private double distance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id",
            referencedColumnName = "id",
            nullable = false)
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            nullable = false)
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "invoice_id",
            referencedColumnName = "id",
            nullable = false)
    private Invoice invoice;
}
