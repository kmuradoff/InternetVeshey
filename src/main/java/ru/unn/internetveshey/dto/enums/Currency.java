package ru.unn.internetveshey.dto.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import ru.unn.internetveshey.utils.CommonEnumSerializer;

@JsonSerialize(using = CommonEnumSerializer.class)
@Getter
public enum Currency {
    RUB("RUB - Russian Ruble"),
    USD("USD - U.S. Dollar"),
    EUR("EUR - Euro"),
    GBP("GBP - British Pound"),
    AZN("AZN - Azerbaijani Manat"),;

    private final String name;

    Currency(String name) {
        this.name = name;
    }
}
