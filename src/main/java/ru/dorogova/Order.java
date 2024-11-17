package ru.dorogova;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс заказа
 */
@AllArgsConstructor
@Getter
@Setter
public class Order {
    private Customer customer; // объект покупатель
    private Product product; // объект товар
    private int quantity; // количество

    @Override
    public String toString() {
        return String.format("Заказ: " + getCustomer() + " " + getProduct() + " количество: " + getQuantity());
    }
}
