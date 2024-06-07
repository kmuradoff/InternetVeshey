package ru.unn.internetveshey.dto;

import lombok.Getter;
import lombok.Setter;
import ru.unn.internetveshey.dto.enums.CarTransmission;

@Getter
@Setter
public class CarModelDto {
    private String name;
    private int year;
    private String engine;
    private CarTransmission transmission;
}
