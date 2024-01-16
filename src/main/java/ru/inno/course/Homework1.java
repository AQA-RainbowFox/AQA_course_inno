package ru.inno.course;

public class Homework1 {
    public static void main(String[] args) {


        // Возвращает true, только если строка пустая, т.е ее длина равна 0
        String river = " ";
        boolean result = river.isEmpty();
        System.out.println(result);

        // Возвращает true, если строка пустая или содержит только "пробелы"
        boolean result_1 = river.isBlank();
        System.out.println(result_1);

        // Возвращает часть строки, начало и конец которой заданы в параметрах метода,
        // второй параметр = индекс последнего элемента - 1
        String city = "владивосток";
        String result_2 = city.substring(1, 4);
        System.out.println(result_2);

        // Возвращает первый найденный индекс начала вхождения строки из параметров в исходной строке
        String quote = "В городе есть горы";
        int result_3 = quote.indexOf("гор");
        System.out.println(result_3);

        // Возвращает последний найденный индекс начала вхождения строки из параметров в исходной строке
        int result_4 = quote.lastIndexOf("гор");
        System.out.println(result_4);

        // Преобразует символы в строке из верхнего регистра в нижний регистр
        String street = "КАЛИНИНГРАДСКАЯ";
        String result_5 = street.toLowerCase();
        System.out.println(result_5);

        // Преобразует символы в строке из нижнего регистра в верхний регистр
        String sea= "Японское";
        String result_6 = sea.toUpperCase();
        System.out.println(result_6);

        // Заменяет часть строки, указанную в первом араметре, на строку, указанную во втором параметре
        String result_7 = sea.replace("Японск", "Чер");
        System.out.println(result_7);

        // Проверяет начинается ли строка с указанного в параметре префикса
        boolean result_8= sea.startsWith("Я");
        System.out.println(result_8);

        // Проверяет заканчивается ли строка указанным в параметре суффиксом
        boolean result_9= sea.endsWith("и");
        System.out.println(result_9);

        // Складывает заданное количество раз строку, на котрую вызван метод
        String result_10= sea.repeat(10);
        System.out.println(result_10);

        // Возвращает true только тогда, когда в этой строке есть указанная
        // в параметре последовательность символов
        boolean result_11= sea.contains("пон");
        System.out.println(result_11);

        // Объединяет строку со строкой из параметра, присоединяя послеюдюю в конец
        String result_12= sea.concat(" море");
        System.out.println(result_12);

        // Убирает пробелы вначале и в конце строки
        String flower = " rose ";
        int result_14 = flower.length();
        String result_13= flower.trim();
        int result_15 = result_13.length();
        System.out.println(result_13);
        System.out.println("length before trim " + result_14);
        System.out.println("length after trim " + result_15);




















    }

}
