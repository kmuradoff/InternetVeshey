package ru.unn.internetveshey.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import ru.unn.internetveshey.dto.enums.CarTransmission;
import ru.unn.internetveshey.dto.enums.Colors;

@Getter
@Setter
public class CarModelDto {
    private String name;
    private int year;
    private String engine;
    private CarTransmission transmission;

    private Colors color;
}
