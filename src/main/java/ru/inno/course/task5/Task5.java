package ru.inno.course.task5;

import ru.inno.course.task3.Movie;

public class Task5 {
    public static void main(String[] args) {
        Movie[] films = {
                new Movie("Девчата", 10, "Комедия/Мелодрамма","СССР", "1962", false),
                new Movie("Зеленая книга", 8.5, "Биография", "США", "2018",true),
                new Movie("Матрица", 9, "Научная фантастика", "США", "1999",true)
        };
        for (Movie m: films) {
            System.out.println("Год: " + m.released + " Название: " + m.name + " Жанр: "+ m.genre + " Рейтинг: "+ m.rating);
        }

    }
}
