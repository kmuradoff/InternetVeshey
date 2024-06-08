package ru.unn.internetveshey.dto;

import lombok.Getter;
import lombok.Setter;
import ru.unn.internetveshey.dto.enums.FuelType;
import ru.unn.internetveshey.jpa.model.CarModel;
import ru.unn.internetveshey.jpa.model.CarTariff;
import ru.unn.internetveshey.jpa.model.Location;

@Getter
@Setter
public class CarDto {
    private String registrationNumber;
    private String carName;
    private int fuelLevel;
    private boolean isActive = false;
    private boolean isLocked = true;
    private CarModel carModel;
    private FuelType fuelType;
    private Location startLocation;
    private Location endLocation;
    private CarTariff carTariff;
}
