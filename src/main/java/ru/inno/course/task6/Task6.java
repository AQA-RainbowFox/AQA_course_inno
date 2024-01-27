package ru.inno.course.task6;

public class Task6 {
    public static void main(String[] args) {
        String[] gamers = new String[10];
        gamers[0] ="Даша";
        gamers[1] ="Леша";
        gamers[2] ="Миша";
        gamers[3] ="Маша";
        gamers[4] ="Глаша";
        gamers[5] ="Саша";
        gamers[6] ="Паша";
        gamers[7] ="Гриша";
        gamers[8] ="Агаша";
        gamers[9] ="Наташа";
        System.out.println("Топ-3 игроков:");
        for (int i = 0; i <= 2; i++) {
            System.out.println(i+1+"-"+gamers[i]);
        }

    }


}
