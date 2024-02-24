package ru.inno.course.certification_1.task_2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
// Здравтсвуйте. было очень сложно раздобраться с условмями, совсем непонятно:
// "Летом поливается в зависимости от влажности воздуха,но не чаще одного раза в два дня."( а где тут тогда зависимость от влажности?
// А также ставит в тупик условие, что если влажность меньше 30, то кактус надо полить, но мы летом должны поливать не чаще раза в два дня.
public class PlantSchedule {
    public void calculate(LocalDate date) {
        SensorHumidity sensorHumidity = new SensorHumidity();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd.MM.yyyy");

        if (sensorHumidity.getHumidity() > 30) {
            if (today.getMonthValue() >= 3 && today.getMonthValue() <= 5) {
                if(date.plusWeeks(1).isBefore(today)){
                    System.out.println("Нужно было полить: " + date.plusWeeks(1).format(formatter));
                } else {
                    System.out.println("Полить: "+ date.plusWeeks(1).format(formatter));
                }
            } else if (today.getMonthValue() > 5 && today.getMonthValue() <= 8) {

                if(date.plusDays(2).isBefore(today)){
                    System.out.println("Нужно было полить: " + date.plusDays(2).format(formatter) );
                } else {
                    System.out.println("Полить: "+ date.plusDays(2).format(formatter) );
                }
            } else if (today.getMonthValue() > 8 && today.getMonthValue() <= 11) {
                if(date.plusWeeks(1).isBefore(today)){
                    System.out.println("Нужно было полить: " + date.plusWeeks(1).format(formatter) );
                } else {
                    System.out.println("Полить: "+ date.plusWeeks(1).format(formatter) );
                }
            } else {
                if(date.plusMonths(1).isBefore(today)){
                    System.out.println("Нужно было полить: " + date.plusMonths(1).format(formatter) );
                } else {
                    System.out.println("Полить: "+ date.plusMonths(1).format(formatter) );
                }
            }
        } else {
            if (today.getMonthValue() >= 6 && today.getMonthValue() <= 8) {
                if(date.plusDays(2).isBefore(today)){
                    System.out.println("Нужно было полить: " + date.plusDays(2).format(formatter) );
                } else {
                    System.out.println("Полить: "+ date.plusDays(2).format(formatter) );
                }
            } else {
                System.out.println("Нужно полить: " + today.format(formatter));
            }
        }
    }
}
