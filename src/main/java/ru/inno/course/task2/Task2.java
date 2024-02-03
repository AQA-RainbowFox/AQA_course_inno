package ru.inno.course.task2;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<String> toDo = new ArrayList<String>();
        toDo.add("Создать список");
        toDo.add("Придумать пять дел");
        toDo.add("Записать дела в список");
        toDo.add("Проверить, что дела записаны");
        toDo.add("Вывести список через цикл");

        for (int i = 0; i < toDo.size(); i++) {
            System.out.println("Задача " + (i + 1) + ": " + toDo.get(i));
        }


    }
}
