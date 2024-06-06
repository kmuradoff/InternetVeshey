package ru.unn.internetveshey.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.unn.internetveshey.dto.enums.FuelType;
import ru.unn.internetveshey.dto.enums.Role;


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
    private Role role;
    private boolean isActive = false;
    private boolean isLocked = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_brand_id",
            referencedColumnName = "id",
            nullable = false)
    private CarBrand carBrand;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id",
            referencedColumnName = "id",
            nullable = false)
    private Location location;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tariff_id",
            referencedColumnName = "id",
            nullable = false)
    private CarTariff carTariff;
}
