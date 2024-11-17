package ru.dorogova;

import ru.dorogova.Enums.Gender;
import ru.dorogova.Enums.Holidays;
import ru.dorogova.Exeptions.AmountException;
import ru.dorogova.Exeptions.CustomerExeption;
import ru.dorogova.Exeptions.ProductException;
import java.time.LocalDate;

/**
 * Задача: Эмуляция интернет-магазина
 * 1. написать классы покупатель, товар и заказ;
 * 2. создать массив покупателей, массив товаров и массив заказов;
 * 3. создать статический метод “совершить покупку” со строковыми
 * параметрами, соответствующими полям объекта заказа. Метод
 * должен вернуть объект заказа
 * 4. Если в метод передан несуществующий покупатель, товар или
 * отрицательное количество, метод должен выбросить
 * соответствующее исключение;
 * 5. Вызвать метод совершения покупки несколько раз таким образом,
 * чтобы заполнить массив покупок возвращаемыми значениями.
 * Обработать исключения.
 * 6. Вывести в консоль итоговое количество совершённых покупок после
 * выполнения приложения.
 *
 * HW:
 * 1. В класс покупателя добавить перечисление с гендерами, добавить в сотрудника свойство «пол» со значением
 * созданного перечисления. Добавить геттеры, сеттеры.
 * 2. Добавить в основную программу перечисление с праздниками (нет праздника, Новый Год, 8 марта, 23 февраля),
 * написать метод, принимающий массив сотрудников, поздравляющий всех сотрудников с Новым Годом, женщин с 8 марта,
 * а мужчин с 23 февраля, если сегодня соответствующий день.
 */
public class Main {

    private static final int COUNT_CUSTOMERS = 3;
    private static final int COUNT_PRODUCTS = 5;
    private static final int COUNT_ORDERS = 5;
    // Массив покупателей
    private static Customer[] customers = new Customer[COUNT_CUSTOMERS];
    // Массив товаров
    private static Product[] products = new Product[COUNT_PRODUCTS];
    // Массив заказов
    private static Order[] orders = new Order[COUNT_ORDERS];

    public static void main(String[] args) {

        customers[0] = new Customer("Кузнецов", "Артур", 30, "89169556145", Gender.MALE);
        customers[1] = new Customer("Дорогова", "Евгения", 29, "89169556134", Gender.FEMALE);
        customers[2] = new Customer("Зорин", "Михаил", 31, "89169746134", Gender.MALE);

        products[0] = new Product("Яблоки", 200.0);
        products[1] = new Product("Бананы", 100.0);
        products[2] = new Product("Картофель", 300.0);
        products[3] = new Product("Апельсины", 50.0);
        products[4] = new Product("Огурцы", 400.0);

        try {
            Order order1 = makePurchase("Дорогова", "Евгения", "Апельсины", 7);
            Order order2 = makePurchase("Кузнецов", "Артур", "Яблоки", 5);
            Order order3 = makePurchase("Кузнецов", "Артур", "Огурцы", 3);
            Order order4 = makePurchase("Зорин", "Михаил", "Картофель", 4);
            Order order5 = makePurchase("Дорогова", "Евгения", "Бананы", 5);
            orders[0] = order1;
            orders[1] = order2;
            orders[2] = order3;
            orders[3] = order4;
            orders[4] = order5;
            int count = 0;
            for (int i = 0; i < orders.length; i++) {
                if (orders[i] != null){
                    count ++;
                }
                System.out.println(orders[i]);
            }
            System.out.println("Итоговое количество совершённых покупок " + count);

        }catch (CustomerExeption e){
            System.out.println(e.getMessage());
        }catch (ProductException e){
            System.out.println(e.getMessage());
        }
        catch (AmountException e){
            System.out.println(e.getMessage());
        }

        // Отправка поздравлений покупателям
        congratulations(customers);
    }

    /**
     * Метод совершения покупки
     * @param lastNameCustomer  // фамилия покупателя
     * @param firstNameCustomer // имя покупателя
     * @param nameProduct // наименование товара
     * @param quantity // количество товара
     * @return
     */
    public static Order makePurchase(String lastNameCustomer, String firstNameCustomer, String nameProduct, int quantity)
            throws CustomerExeption, ProductException, AmountException {
        Customer customerNull = null; // Инициализация пустого покупателя
        Product productNull = null; // Инициализация пустого товара

        for (Customer customer : customers){
            if (customer.getLastName().equals(lastNameCustomer) && (customer.getFirstName().equals(firstNameCustomer))){
                customerNull = customer;
                break;
            }
        }
        if (customerNull == null){
            throw new CustomerExeption("Такого покупателя не существует: " + lastNameCustomer + " " + firstNameCustomer);
        }

        for (Product product : products){
            if (product.getName().equals(nameProduct)){
                productNull = product;
                break;
            }
        }
        if (productNull == null){
            throw new ProductException("Такого товара не существует: " + nameProduct);
        }

        if (quantity <= 0 || quantity >= 100){
            throw new AmountException("Указано неверное количество товара");
        }

        return new Order(customerNull, productNull, quantity);
    }

    /**
     * Метод поздравления покупателей
     * @param customers массив с покупателями
     */
    public static void congratulations(Customer[] customers){
        LocalDate testDate = LocalDate.of(2024,3,8); // дата меняется для тестов отправки поздравлений
        for (Customer customer : customers){
            if (testDate.getMonthValue() == Holidays.NEW_YEAR.getMonth()
                    && testDate.getDayOfMonth() == Holidays.NEW_YEAR.getDay()){
                System.out.println("Поздравляем с Новым годом! " + customer);
            }

            if (testDate.getMonthValue() == Holidays.DEFENDER_FATHERLAND_DAY.getMonth()
                    && testDate.getDayOfMonth() == Holidays.DEFENDER_FATHERLAND_DAY.getDay()
                    && customer.getGender() == Gender.MALE){
                System.out.println("Поздравляем с Днем защитника Отечества! " + customer);
            }

            if (testDate.getMonthValue() == Holidays.INTERNATIONAL_WOMENS_DAY.getMonth()
                    && testDate.getDayOfMonth() == Holidays.INTERNATIONAL_WOMENS_DAY.getDay()
                    && customer.getGender() == Gender.FEMALE){
                System.out.println("Поздравляем с Международным женским днем! " + customer);
            }
        }
    }
}