package ru.dorogova.Exeptions;

/**
 * Исключение, выбрасываемое при несуществующем покупателе
 */
public class CustomerExeption extends Exception{

    public CustomerExeption(String message){
        super(message);
    }
}
