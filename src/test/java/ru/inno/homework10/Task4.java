package ru.inno.homework10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4 {
    private WebDriver driver;

    @BeforeEach
    public void SetDriver() {
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void pictureAttributeNameTest() {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(15));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("img"), 3));

        List<WebElement> images = driver.findElements(By.cssSelector("img"));

        assertTrue(images.get(3).getAttribute("src").contains("img/award.png"));
    }
}
