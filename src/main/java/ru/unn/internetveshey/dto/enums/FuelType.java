package ru.unn.internetveshey.dto.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import ru.unn.internetveshey.utils.CommonEnumSerializer;

@Getter
@JsonSerialize(using = CommonEnumSerializer.class)
public enum FuelType {
    PETROL("Petrol"),
    DIESEL("Diesel"),
    ETHANOL("Ethanol"),
    NATURAL_GAS("Natural Gas"),
    LPG("LPG"),
    MILD_HYBRID_DIESEL("Mild-Hybrid Diesel"),
    HYBRID_PETROL("Hybrid Petrol"),
    PLUGIN_HYBRID_PETROL("Plug-in Hybrid Petrol"),
    FUEL_CELL("Fuel cell"),
    ELECTRIC("Electric");

    private final String name;

    FuelType(String name) {
        this.name = name;
    }
}
