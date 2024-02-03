package ru.inno.course.task4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        ArrayList<Company> companies = new ArrayList<>();

        ArrayList<String> disneyPortfolio = new ArrayList<>();
        disneyPortfolio.add("Круэлла");
        disneyPortfolio.add("Пираты карибского моря");
        disneyPortfolio.add("Кошмар перед Рождеством");

        Company disney = new Company("Дисней", 1923, disneyPortfolio);
        companies.add(disney);


        ArrayList<String> sonyPortfolio = new ArrayList<>();
        sonyPortfolio.add("Охотники за привидениями");
        sonyPortfolio.add("Код да Винчи");
        sonyPortfolio.add("Ангелы Чарли");

        Company sony = new Company("Сони", 1987, sonyPortfolio);
        companies.add(sony);


        ArrayList<String> universalPortfolio = new ArrayList<>();
        universalPortfolio.add("Гладиатор");
        universalPortfolio.add("Люси");
        universalPortfolio.add("Список Шиндлера");

        Company universal = new Company("Юниверсал", 1912, universalPortfolio);
        companies.add(universal);


        for (int i = 0; i < companies.size(); i++) {
            System.out.println(companies.get(i));

        }


    }

}
