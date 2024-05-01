package ru.inno.homework10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1 {

    private WebDriver driver;

    @BeforeEach
    public void SetDriver() {
        driver = new ChromeDriver();
        driver.get("http://uitestingplayground.com/sampleapp");

    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test

    public void authorizationSuccessTest() {
        String user = "inno";
        String pass = "pwd";

        driver.findElement(By.cssSelector("input[type=text]")).sendKeys(user);
        driver.findElement(By.cssSelector("input[type=password]")).sendKeys(pass);

        driver.findElement(By.cssSelector("#login")).click();

        assertEquals("Welcome, " + user + "!", driver.findElement(By.cssSelector("#loginstatus")).getText());
    }

}
