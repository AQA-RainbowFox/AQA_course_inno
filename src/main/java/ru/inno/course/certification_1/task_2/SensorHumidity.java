package ru.inno.course.certification_1.task_2;

import java.util.Random;

public class SensorHumidity {
    public int getHumidity() {
        Random rnd = new Random();
        int result = rnd.ints(0, 100).findFirst().getAsInt();
        System.out.println("Humidity: " + result + "%");
        return 35;
    }
}
