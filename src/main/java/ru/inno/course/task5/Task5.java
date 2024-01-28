package ru.inno.course.task5;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите пароль");
        String password = sc.next();

        boolean isDigitFound = false;
        boolean isSymbolFound = false;

        if (password.length() < 8) {
            System.out.println("Пароль менее 8 символов");
        } else {
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) == '0' || password.charAt(i) == '1' || password.charAt(i) == '2' || password.charAt(i) == '3' || password.charAt(i) == '4' || password.charAt(i) == '5' || password.charAt(i) == '6' || password.charAt(i) == '7' || password.charAt(i) == '8' || password.charAt(i) == '9') {
                    isDigitFound = true;
                }
                if (password.charAt(i) == '!' || password.charAt(i) == '@' || password.charAt(i) == '#' || password.charAt(i) == '$' || password.charAt(i) == '%' || password.charAt(i) == '^' || password.charAt(i) == '&' || password.charAt(i) == '*' || password.charAt(i) == '№') {
                    isSymbolFound = true;
                }
            }
            if (!isDigitFound) {
                System.out.println("Пароль должен содержать минимум 1 цифру");
            } else if (!isSymbolFound) {
                System.out.println("Пароль должен содержать минимум 1 спецсимвол: !, @, #, $, %, ^, &, *, №");
            }
            if (isDigitFound && isSymbolFound) {
                System.out.println("Пароль принят");
            }
        }
    }
}
