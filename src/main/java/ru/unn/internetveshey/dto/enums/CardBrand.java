package ru.unn.internetveshey.dto.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import ru.unn.internetveshey.utils.CommonEnumSerializer;

@JsonSerialize(using = CommonEnumSerializer.class)
@Getter
public enum CardBrand {
    VISA("VISA"),
    MASTERCARD("Mastercard"),
    AMERICAN_EXPRESS("American Express"),
    DISCOVER("Discover"),
    MIR("МИР");

    private final String name;

    CardBrand(String name) {
        this.name = name;
    }
}
