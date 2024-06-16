package ru.inno.course.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigHelper {

    private static final String CONFIG_FILE = "src/main/resources/config.properties";

    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream(CONFIG_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public static String getUserName() {
        return properties.getProperty("userName");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static String getPageProfileRows() {
        return properties.getProperty("noRowsInfo");
    }

    public static int countBookAddProfileTest() {
        return Integer.parseInt(properties.getProperty("countBookAddProfileTest"));
    }

    public static int expectedCountBookAddProfileTest() {
        return Integer.parseInt(properties.getProperty("expectedCountBookAddProfileTest"));
    }

    public static int countBookAddAndDeleteTest() {
        return Integer.parseInt(properties.getProperty("countBookAddAndDeleteTest"));
    }

    public static int expectedCountBookAddAndDeleteTest() {
        return Integer.parseInt(properties.getProperty("expectedCountBookAddAndDeleteTest"));
    }

    public static String countDropDownMenu() {
        return properties.getProperty("countDropDownMenu");
    }
}
