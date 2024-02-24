package ru.inno.course.certification_1.task_2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("Введите дату последнего полива в формате \"дд.мм.гггг\":");
        LocalDate date = LocalDate.parse(sc.nextLine(), formatter);
        PlantSchedule plantSchedule = new PlantSchedule();
        plantSchedule.calculate(date);

    }
}
