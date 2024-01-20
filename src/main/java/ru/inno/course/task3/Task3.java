package ru.inno.course.task3;

public class Task3 {
    public static void main(String[] args) {
        Item Item_1 = new Item("187914651", "Кошелек", 499.99, 123, "Бирюзовый", 0.300);
        Item Item_2 = new Item("18990266", "Сумочка", 23400.0, 12, 1.2);
        Item Item_3 = new Item("20045100", "Бумажник", 5, "Бежевый", 0.21);
        Item Item_4 = new Item("12039393", "Клатч", 499.99, 10, "Малиновый");
        Item Item_5 = new Item("00004628", "Ключница", 600, 200, "Серый", 0.154);

        System.out.println("Артикул" + " = " +Item_1.partNumber + ", " + "Наименование" + " = " +Item_1.name + ", " +"Цена" + " = " +Item_1.price + ", " +"Количество" + " = " +Item_1.quantity + ", " +"Цвет" + " = " +Item_1.color + ", " +"Вес" + " = " + Item_1.weigt);
        System.out.println("Артикул" + " = " +Item_2.partNumber + ", " + "Наименование" + " = " +Item_2.name + ", " +"Цена" + " = " +Item_2.price + ", " +"Количество" + " = " +Item_2.quantity + ", " +"Вес" + " = " +Item_2.weigt);
        System.out.println("Артикул" + " = " +Item_3.partNumber + ", " + "Наименование" + " = " +Item_3.name + ", " +"Количество" + " = " +Item_3.quantity + ", " +"Цвет" + " = " +Item_3.color + ", " +"Вес" + " = " +Item_3.weigt);
        System.out.println("Артикул" + " = " +Item_4.partNumber + ", " + "Наименование" + " = " +Item_4.name + ", " +"Цена" + " = " +Item_4.price + " ," +"Количество" + " = " +Item_4.quantity + ", " +"Цвет" + " = " +Item_4.color);
        System.out.println("Артикул" + " = " +Item_5.partNumber + ", " + "Наименование" + " = " +Item_5.name + ", " +"Цена" + " = " +Item_5.price + ", " +"Количество" + " = " +Item_5.quantity + ", " +"Цвет" + " = " +Item_5.color + ", " +"Вес" + " = " +Item_5.weigt);


    }
}