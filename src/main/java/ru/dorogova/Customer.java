package ru.dorogova;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.dorogova.Enums.Gender;

/**
 * Класс покупателя
 */
@AllArgsConstructor
@Getter
@Setter
public class Customer {

    private String lastName; // Фамилия
    private String firstName; // Имя
    private int age; // Возраст
    private String phone; // Номер телефона
    private Gender gender; // пол покупателя

    @Override
    public String toString() {
        return String.format("Фамилия: " + getLastName() + " Имя: " + getFirstName());
    }
}
