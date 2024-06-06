package ru.unn.internetveshey.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.unn.internetveshey.jpa.model.payment.Invoice;

import java.time.LocalDateTime;

@Getter
@Setter
public class RideDto {
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime endTime;
    private double distance;
    private CarDto car;
    private UserInformationDto user;
    private Invoice invoice;
}
