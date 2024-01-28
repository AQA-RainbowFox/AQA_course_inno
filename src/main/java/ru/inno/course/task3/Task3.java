package ru.inno.course.task3;

public class Task3 {
    public static void main(String[] args) {
        int peremennaya = 5;

        if (peremennaya % 2 == 0 && peremennaya % 4 == 0) {
            System.out.println("Четное число. Кратно четырем");
        }
        if (peremennaya % 2 != 0 && peremennaya % 3 == 0) {
            System.out.println("Нечетное число. Кратно трем.");
        }
    }
}


