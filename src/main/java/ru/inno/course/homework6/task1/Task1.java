package ru.inno.course.homework6.task1;

import java.io.IOException;

public class Task1 {
    public static void main(String[] args) {
        try {
            Copier.copyTextFile("src/main/java/ru/inno/course/homework6/task1/readFile.txt", "src/main/java/ru/inno/course/homework6/task1/writeFile.txt");
        } catch (IOException e) {
            System.out.println("Что-то пошло не так");
            System.out.println(e);
        }

    }
}
