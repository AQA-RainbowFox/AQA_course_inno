package ru.inno.course.homework6.task2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task2 {
    public static void main(String[] args) {
//        LocalDate publishDate = LocalDate.now().minusDays(1);
//        LocalTime publishTime = LocalTime.now().minusHours(23).minusMinutes(47);
//        LocalDateTime timeStamp = LocalDateTime.of(publishDate, publishTime);
//        Не стала использовать, тк в таком варианте timeStamp не учитывает часы и дни вместе, а считает их по отдельности

        LocalDateTime timeStamp = LocalDateTime.of(2024, 2, 9, 15, 34);
        System.out.println(timeStamp);
        System.out.println(LocalDateTime.now());

        HumanReadableTimestamp hrt = new HumanReadableTimestampImpl();
        System.out.println(hrt.getTimestamp(timeStamp));
    }
}
