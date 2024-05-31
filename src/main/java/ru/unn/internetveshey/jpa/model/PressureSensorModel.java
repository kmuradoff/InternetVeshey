package ru.unn.internetveshey.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "pressure_sensor", schema = "internet_veshey")
@Getter
@Setter
@NoArgsConstructor
public class PressureSensorModel extends DeviceModel {
    private float lastPressure;
    private LocalDateTime lastMeasurementTime;
}
