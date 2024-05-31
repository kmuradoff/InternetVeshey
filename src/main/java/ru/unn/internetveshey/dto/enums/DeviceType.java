package ru.unn.internetveshey.dto.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

@Getter
@JsonSerialize(using = CommonEnumSerializer.class)
public enum DeviceType {
    TEMPERATURE_SENSOR("Temperature Sensor"),
    PRESSURE_SENSOR("Pressure Sensor");

    private final String name;

    DeviceType(String name) {
        this.name = name;
    }

}
