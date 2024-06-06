package ru.unn.internetveshey.dto;

import lombok.Getter;
import lombok.Setter;
import ru.unn.internetveshey.dto.enums.Colors;

import java.util.Set;

@Getter
@Setter
public class CarBrandDto {
    private String name;
    private byte[] brandLogo;
    private Set<CarModelDto> carModels;
}
