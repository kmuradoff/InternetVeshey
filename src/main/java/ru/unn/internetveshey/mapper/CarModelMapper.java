package ru.unn.internetveshey.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.unn.internetveshey.dto.CarBrandDto;
import ru.unn.internetveshey.dto.CarModelDto;
import ru.unn.internetveshey.jpa.model.CarBrand;
import ru.unn.internetveshey.jpa.model.CarModel;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarModelMapper {
    CarModelDto fromCarModel(CarModel carModel);
    CarModel toCarModel(CarModelDto carModelDto);
}
