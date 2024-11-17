package ru.dorogova;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс товара
 */
@AllArgsConstructor
@Setter
@Getter
public class Product {

    private String name; // Наименование товара
    private double price; // Цена товара

    @Override
    public String toString() {
        return String.format("Наименование товара: " + getName());
    }
}
