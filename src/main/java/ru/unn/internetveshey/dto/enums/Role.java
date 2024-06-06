package ru.unn.internetveshey.dto.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import ru.unn.internetveshey.utils.CommonEnumSerializer;

@Getter
@JsonSerialize(using = CommonEnumSerializer.class)
public enum Role {
    ADMIN("Администратор"),
    USER("Пользователь"),
    GUEST("Гость");

    private final String value;

    Role(String value) {
        this.value = value;
    }
}
