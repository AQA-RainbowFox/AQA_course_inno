package ru.inno.course.task9;

public class Car {
    private int currentSpeed = 0;
    private String color;
    private String brand;
    private String model;

    public Car(int currentSpeed, String color, String brand, String model) {
        if (currentSpeed <= 10) {
            this.currentSpeed = 0;
        } else {
            this.currentSpeed = currentSpeed;
        }
        this.color = color;
        this.brand = brand;
        this.model = model;
    }

    public Car(String color, String brand, String model) {
        this.color = color;
        this.brand = brand;
        this.model = model;
    }

    public int getCurrentSpeed() {
        return this.currentSpeed;
    }

    public void speedUp(int inputSpeed) {
        currentSpeed = currentSpeed + inputSpeed;
    }

    public void brake() {
        currentSpeed = currentSpeed - 10;
        if (currentSpeed < 0) {
            this.currentSpeed = 0;
        }
    }
}
