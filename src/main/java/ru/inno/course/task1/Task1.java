package ru.inno.course.task1;

public class Task1 {
    public static void main(String[] args) {
        String[] todoList = new String[5];
        todoList[0] = "1.Создать массив";
        todoList[1] = "2.Придумать пять дел";
        todoList[2] = "3.Записать дела в массив";
        todoList[3] = "4.Проверить, что дела записаны";
        todoList[4] = "5.Порадоваться выполненному заданию";
        for (String CurrentTodo : todoList
        ) {
            System.out.println(CurrentTodo);
        }

    }
}

