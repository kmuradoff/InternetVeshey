package ru.unn.internetveshey.dto.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import ru.unn.internetveshey.utils.CommonEnumSerializer;

@Getter
@JsonSerialize(using = CommonEnumSerializer.class)
public enum CarTransmission {
    MANUAL("Manual"),
    AUTOMATIC("Automatic"),
    SEMI_AUTOMATIC("Semi-automatic"),
    CONTINUOUSLY_VARIABLE("Continuously variable"),
    DUAL_CLUTCH("Dual-clutch");

    private final String name;

    CarTransmission(String name) {
        this.name = name;
    }
}
