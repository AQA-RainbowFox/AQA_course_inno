package ru.inno.course.task2;

public class Room {
    double square;
    double length;
    double height;
    double width;
    int numberOfWindow;

    public Room(double square, double length, double height, double width, int numberOfWindow) {
        this.square = square;
        this.length = length;
        this.height = height;
        this.width = width;
        this.numberOfWindow = numberOfWindow;
    }

    @Override
    public String toString() {
        return "Площадь = " + square + ", " +
                "Длина = " + length  +
                ", Высота = " + height +
                ", Ширина = " + width  +
                ", Количество окон = " + numberOfWindow;
    }
}
