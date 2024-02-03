package ru.inno.course.task1;

public class Task1 {

    public static void main(String[] args) {
        Player playerXml = new Player(123, "RainbowFox", true);
        Player playerDb = new Player(123, "RainbowFox", true);

        System.out.println(playerXml == playerDb);

        System.out.println(playerXml.equals(playerDb));

    }
}
