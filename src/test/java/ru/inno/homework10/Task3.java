package ru.inno.homework10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3 {

    private WebDriver driver;

    @BeforeEach
    public void SetDriver() {
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/data-types.html");
    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void fillingOutFormTest() {
        String firstName = "Зефир";
        String lastName = "Котовских";
        String address = "Квартира";
        String city = "Калининград";
        String country = "Россия";
        String jobPosition = "Кот";
        String company = "Семья";

        final String IS_RED_COLOR = "rgba(132, 32, 41, 1)";
        final String IS_GREEN_COLOR = "rgba(15, 81, 50, 1)";

        driver.findElement(By.cssSelector("input[name=first-name]")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[name=last-name]")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input[name=address]")).sendKeys(address);
        driver.findElement(By.cssSelector("input[name=city]")).sendKeys(city);
        driver.findElement(By.cssSelector("input[name=country]")).sendKeys(country);
        driver.findElement(By.cssSelector("input[name=job-position]")).sendKeys(jobPosition);
        driver.findElement(By.cssSelector("input[name=company]")).sendKeys(company);

        driver.findElement(By.cssSelector("button[type=submit]")).click();

        assertEquals(IS_GREEN_COLOR, driver.findElement(By.cssSelector("#first-name")).getCssValue("color"));
        assertEquals(IS_GREEN_COLOR, driver.findElement(By.cssSelector("#last-name")).getCssValue("color"));
        assertEquals(IS_GREEN_COLOR, driver.findElement(By.cssSelector("#city")).getCssValue("color"));
        assertEquals(IS_GREEN_COLOR, driver.findElement(By.cssSelector("#country")).getCssValue("color"));
        assertEquals(IS_GREEN_COLOR, driver.findElement(By.cssSelector("#job-position")).getCssValue("color"));
        assertEquals(IS_GREEN_COLOR, driver.findElement(By.cssSelector("#company")).getCssValue("color"));

        assertEquals(IS_RED_COLOR, driver.findElement(By.cssSelector("#zip-code")).getCssValue("color"));
        assertEquals(IS_RED_COLOR, driver.findElement(By.cssSelector("#e-mail")).getCssValue("color"));
        assertEquals(IS_RED_COLOR, driver.findElement(By.cssSelector("#phone")).getCssValue("color"));
    }


}
