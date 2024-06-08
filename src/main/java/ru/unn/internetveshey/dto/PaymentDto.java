package ru.unn.internetveshey.dto;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.unn.internetveshey.dto.enums.CardBrand;

import java.util.Date;

@Getter
public class PaymentDto {
    private CardBrand cardBrand;
    private String cardNumber;
    @DateTimeFormat(pattern = "MM/yyyy")
    private Date validThru;
    private String cardHolder;
    private int cvc;
}
