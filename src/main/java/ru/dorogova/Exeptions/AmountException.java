package ru.dorogova.Exeptions;

/**
 * Исключение, выбрасываемое при неверном количестве товара
 */
public class AmountException extends Exception{

    public AmountException(String message) {
        super(message);
    }
}
