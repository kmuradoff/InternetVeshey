package ru.unn.internetveshey.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.unn.internetveshey.dto.RideDto;
import ru.unn.internetveshey.jpa.model.Ride;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RideMapper {
    RideDto fromRide(Ride ride);
    Ride toRide(RideDto rideDto);
}
