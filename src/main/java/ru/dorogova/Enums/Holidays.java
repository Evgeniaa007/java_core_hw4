package ru.dorogova.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Перечисление праздников
 */
@AllArgsConstructor
@Getter
public enum Holidays {

    NEW_YEAR(1, 1),
    DEFENDER_FATHERLAND_DAY(2, 23),
    INTERNATIONAL_WOMENS_DAY(3, 8),
    NOTHING(0, 0);

    private final int month;
    private final int day;
}
