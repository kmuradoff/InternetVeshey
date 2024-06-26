package ru.unn.internetveshey.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.unn.internetveshey.dto.enums.CarTransmission;

@Entity
@Getter
@Setter
@Table(name = "car_model", schema = "internet_veshey")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int year;
    private String engine;
    @Enumerated(EnumType.STRING)
    private CarTransmission transmission;
}
