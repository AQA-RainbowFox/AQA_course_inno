package ru.inno.course.certification_1.task_1;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        double number = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите длину забора в метрах:");
        if (sc.hasNextDouble()){
            number = sc.nextDouble();
        } else {
            System.out.println(" Вы ввели не число, нужно перезапустить программу и ввести число");
        }
        // Посчитаем длину забора, котрая необходима для надписи в метрах
       double fenceLength = (double)(((62*5)+(12*3))/100);
       if (number>=fenceLength){
           System.out.println("Забор подходит для написания признания");
       } else{
           System.out.println("Забор недостаточно длинный для признания");
       }
    }

}
