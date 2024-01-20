package ru.inno.course.task1;
public class Task1 {
    public static void main(String[] args) {
        String cardNumber = "1234567890123456";
        String result = cardNumber.replaceAll(" ", "");
        System.out.println(result);
        String result_1 = result.replaceAll("\\d{12}", "****\s****\s****\s");
        System.out.println(result_1);


    }
}

