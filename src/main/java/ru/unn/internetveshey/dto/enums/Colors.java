package ru.unn.internetveshey.dto.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import ru.unn.internetveshey.utils.CommonEnumSerializer;

@JsonSerialize(using = CommonEnumSerializer.class)
@Getter
public enum Colors {
    WHITE("White"),
    BLACK("Black"),
    RED("Red"),
    BLUE("Blue"),
    GREEN("Green"),
    YELLOW("Yellow"),
    ORANGE("Orange"),
    PURPLE("Purple"),
    PINK("Pink"),
    BROWN("Brown"),
    GREY("Grey"),
    SILVER("Silver"),
    GOLD("Gold");

    private final String name;

    Colors(String name) {
        this.name = name;
    }
}
