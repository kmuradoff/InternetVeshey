package ru.unn.internetveshey.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "car_tariff", schema = "internet_veshey")
public class CarTariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float perMinute;
    private float perKilometer;
    private float perHour;
    private float perDay;
}
