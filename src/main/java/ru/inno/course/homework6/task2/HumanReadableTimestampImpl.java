package ru.inno.course.homework6.task2;

import java.time.Duration;
import java.time.LocalDateTime;

public class HumanReadableTimestampImpl implements HumanReadableTimestamp {
    // Не поняла как учесть одновременно два условния про день:
    // если публикация была сделана 1 день назад,написать: опубликовано вчера
    // и
    //вовсехостальныхслучаях,написать опубликовано X день назад(1,21,31,101 день назад)
    // нет описания как считать "Вчера" и как считать "День назад"
    @Override
    public String getTimestamp(LocalDateTime eventTime) {
        LocalDateTime timeNow = LocalDateTime.now();
        Duration duration = Duration.between(eventTime, timeNow);

        long days = duration.toDays();
        long hours = duration.toHours();
        long minutes = duration.toMinutes();

        if (days < 1) {
            if (minutes < 60) {
                if (minutes == 1 || minutes == 21 || minutes == 31 || minutes == 41 || minutes == 51) {
                    return "опубликовано " + minutes + " минуту назад";
                } else if (minutes == 2 || minutes == 3 || minutes == 4 || minutes == 22 || minutes == 54) {
                    return "опубликовано " + minutes + " минуты назад";
                } else {
                    return "опубликовано " + minutes + " минут назад";
                }
            } else {
                if (hours == 2 || hours == 3 || hours == 4 || hours == 22 || hours == 23) {
                    return "опубликовано " + hours + " часа назад";
                } else if (hours == 1 || hours == 21) {
                    return "опубликовано " + hours + " час назад";
                } else {
                    return "опубликовано " + hours + " часов назад";
                }
            }
        } else if (days == 1) {
            return "опубликовано вчера";
        } else {
            if (days == 5 || days == 20 || days == 99 || days == 100 || days == 111) {
                return "опубликовано " + days + " дней назад";
            } else if (days == 2 || days == 3 || days == 4 || days == 22 || days == 23 || days == 92) {
                return "опубликовано " + days + " дня назад";
            } else if (days == 21 || days == 31 || days == 101) {
                return "опубликовано " + days + " день назад";
            } else {
                return "опубликовано " + days + " дней назад";
            }
        }
    }
}
