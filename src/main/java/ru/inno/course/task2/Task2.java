package ru.inno.course.task2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Task2 {
    public static void main(String[] args) {
        double [] fractionalNumber = new double [3];
        BigDecimal bd = new BigDecimal("1.000001");
        fractionalNumber[0] = Double.parseDouble(String.format("%.5f", Math.PI).replace(",","."));
        fractionalNumber[1] = Double.parseDouble(String.format("%.5f", Math.E).replace(",","."));
        fractionalNumber[2] = bd.setScale(5, RoundingMode.CEILING).doubleValue();
        System.out.println(fractionalNumber[0]);
        System.out.println(fractionalNumber[1]);
        System.out.print(fractionalNumber[2]);

    }
}
