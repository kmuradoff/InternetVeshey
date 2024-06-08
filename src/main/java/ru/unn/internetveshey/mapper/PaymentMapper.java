package ru.unn.internetveshey.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.unn.internetveshey.dto.CarBrandDto;
import ru.unn.internetveshey.dto.PaymentDto;
import ru.unn.internetveshey.jpa.model.CarBrand;
import ru.unn.internetveshey.jpa.model.payment.PaymentCard;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentMapper {
    PaymentDto fromPayment(PaymentCard paymentCard);
    PaymentCard toPayment(PaymentDto paymentDto);
}
