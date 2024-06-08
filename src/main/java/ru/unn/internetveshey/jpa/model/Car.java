package ru.unn.internetveshey.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.unn.internetveshey.dto.enums.FuelType;

@Entity
@Getter
@Setter
@Table(name = "car", schema = "internet_veshey")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String registrationNumber;
    private String carName;
    private int fuelLevel;
    private boolean isActive = false;
    private boolean isLocked = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_model_id",
            referencedColumnName = "id",
            nullable = false)
    private CarModel carModel;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "start_location_id",
            referencedColumnName = "id",
            nullable = false)
    private Location startLocation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "end_location_id",
            referencedColumnName = "id",
            nullable = false)
    private Location endLocation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tariff_id",
            referencedColumnName = "id",
            nullable = false)
    private CarTariff carTariff;



}