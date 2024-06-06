package ru.unn.internetveshey.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.unn.internetveshey.dto.CarBrandDto;
import ru.unn.internetveshey.dto.CarDto;
import ru.unn.internetveshey.jpa.model.Car;
import ru.unn.internetveshey.jpa.model.CarBrand;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarBrandMapper {
    CarBrandDto fromCarBrand(CarBrand carBrand);
    CarBrand toCarBrand(CarBrandDto carBrandDto);
}
