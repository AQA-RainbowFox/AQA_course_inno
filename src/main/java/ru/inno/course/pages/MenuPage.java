package ru.inno.course.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage {
    private final WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на \"Book Store\" в левом боковом меню")
    public void clickOnBookStore() {
        WebElement menuItem = driver.findElements(By.cssSelector(".btn.btn-light")).get(30);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", menuItem);
        menuItem.click();
    }
}