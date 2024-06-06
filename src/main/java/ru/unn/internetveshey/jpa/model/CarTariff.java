package ru.unn.internetveshey.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.temporal.ChronoUnit;

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

    public float calculatePrice(Ride ride) {
        float price = 0;
        long minutes = ride.getStartTime().until(ride.getEndTime(), ChronoUnit.MINUTES);
        if (minutes < 60) {
            price = perMinute * minutes;
        } else if (minutes < 1440) {
            price = perHour * ((float) minutes / 60);
        } else {
            price = perDay * ((float) minutes / 1440);
        }
        price += perKilometer * ride.getDistance();
        return price;
    }
}
