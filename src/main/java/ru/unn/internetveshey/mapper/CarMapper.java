package ru.unn.internetveshey.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.unn.internetveshey.dto.CarDto;
import ru.unn.internetveshey.jpa.model.Car;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarMapper {
    CarDto fromCar(Car car);
    Car toCar(CarDto carDto);
}
