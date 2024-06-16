package ru.inno.course.utils;

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
        return properties.getProperty("username");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static String getTokenHeader() {
        return properties.getProperty("headerForToken");
    }

    public static String getDisplayName() {
        return properties.getProperty("displayName");
    }

    public static String getAuthPath() {
        return properties.getProperty("authPath");
    }

    public static String getCompanyPath() {
        return properties.getProperty("companyPath");
    }
    public static String companyActiveParam() {
        return properties.getProperty("companyActiveParam");
    }

    public static boolean companyActiveFlag(){
        return Boolean.parseBoolean(properties.getProperty("companyActiveFlag"));
    }
    public static String getCompanyDeletePath() {
        return properties.getProperty("companyDeletePath");
    }
    public static String getEmployeePath() {
        return properties.getProperty("employeePath");
    }

    public static String getConnectionString() {
        return properties.getProperty("connectionString");
    }
    public static String getUserDb() {
        return properties.getProperty("userDb");
    }
    public static String getPasswordDb() {
        return properties.getProperty("passwordDb");
    }

    public static boolean employeeActiveFlag(){
        return Boolean.parseBoolean(properties.getProperty("employeeActiveFlag"));
    }

    public static String getCreateCompanyPath(){
        return properties.getProperty("createCompanyPath");
    }

}
