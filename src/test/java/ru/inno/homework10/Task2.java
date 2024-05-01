package ru.inno.homework10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2 {

    private WebDriver driver;

    @BeforeEach
    public void SetDriver() {
        driver = new ChromeDriver();
        driver.get("http://uitestingplayground.com/textinput");

    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void changeNameButtonTest() {
        String nameButton = "Привет!";
        driver.findElement(By.cssSelector("input[type=text]")).sendKeys(nameButton);

        driver.findElement(By.cssSelector("#updatingButton")).click();

        assertEquals(nameButton, driver.findElement(By.cssSelector("#updatingButton")).getText());
    }
}
