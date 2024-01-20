package ru.inno.course.task3;

public class Item {
    String name;
    String partNumber;
    double price;
    int quantity;
    String color;
    double weigt;

    public Item(String partNumber, String name, double price, int quantity, String color, double weigt) {
        this.name = name;
        this.partNumber = partNumber;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.weigt = weigt;

    }

    public Item( String partNumber,String name, int quantity, String color, double weigt) {
        this.name = name;
        this.partNumber = partNumber;
        this.quantity = quantity;
        this.color = color;
        this.weigt = weigt;
    }
    public Item( String partNumber,String name, double price, int quantity, double weigt) {
        this.name = name;
        this.partNumber = partNumber;
        this.price = price;
        this.quantity = quantity;
        this.weigt = weigt;
    }

    public Item(String partNumber,String name,double price, int quantity, String color) {
        this.name = name;
        this.partNumber = partNumber;
        this.price = price;
        this.quantity = quantity;
        this.color = color;

    }
}
