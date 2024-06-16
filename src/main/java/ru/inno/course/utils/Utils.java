package ru.inno.course.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

    public static String generateAlphabetic(int wordsCount) {
        return RandomStringUtils.randomAlphabetic(wordsCount).toLowerCase() + "_test";
    }

    public static String generateFirstName() {
        return RandomStringUtils.randomAlphabetic(6).toLowerCase() + "_test";
    }

    public static String generateLastName() {
        return RandomStringUtils.randomAlphabetic(8).toLowerCase() + "_test";
    }

    public static String generateEmail() {
        return RandomStringUtils.randomAlphabetic(4)
                .toLowerCase() + "@" +
                RandomStringUtils.randomAlphabetic(4).toLowerCase() + ".ru";
    }

    public static String generatePhone() {
        return "+" + RandomStringUtils.randomNumeric(11);
    }
}
