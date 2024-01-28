package ru.inno.course.task9;

public class MyProgram {
    public static void main(String[] args) {
        Car myCar = new Car("red", "mazda", "3");

        System.out.println(myCar.getCurrentSpeed());

        myCar.speedUp(25);

        System.out.println(myCar.getCurrentSpeed());

        myCar.brake();
        System.out.println(myCar.getCurrentSpeed());

        myCar.brake();
        System.out.println(myCar.getCurrentSpeed());

        myCar.brake();
        System.out.println(myCar.getCurrentSpeed());
    }
}
