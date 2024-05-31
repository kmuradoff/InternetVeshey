package ru.unn.internetveshey.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "temperature_sensor", schema = "internet_veshey")
@NoArgsConstructor
@Getter
@Setter
public class TemperatureSensorModel extends DeviceModel {
    private float lastTemperature;
    private LocalDateTime lastMeasurementTime;
}
