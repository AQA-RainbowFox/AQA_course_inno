package ru.inno.course.task3;

import java.util.ArrayList;

public class Task3 {
    public static void main(String[] args) {

        ArrayList<Movie> films = new ArrayList<Movie>();
        films.add(new Movie("Девчата", 10, "Комедия/Мелодрамма", "СССР", "1962", false));
        films.add(new Movie("Зеленая книга", 8.5, "Биография", "США", "2018", true));
        films.add(new Movie("Матрица", 9, "Научная фантастика", "США", "1999", true));

        System.out.println("Фильм в списке с индексом 1: "+ films.get(1));


    }
}
