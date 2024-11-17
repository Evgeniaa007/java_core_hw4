package ru.dorogova.Exeptions;

/**
 * Исключение, выбрасываемое при несуществующем товаре
 */
public class ProductException extends Exception{

    public ProductException(String message) {
        super(message);
    }
}
