package ru.inno.course.task6;

public class Task6 {
    public static void main(String[] args) {
        String password = "Qwerty0987654321";
        String correctPassword = "Qwerty0987654321";

        if (password.equals(correctPassword)) {
            System.out.println("Доступ разрешен");
        } else {
            System.out.println("Доступ запрещен");
        }
    }
}

