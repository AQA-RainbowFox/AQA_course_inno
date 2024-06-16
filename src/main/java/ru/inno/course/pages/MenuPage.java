package ru.inno.course.pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

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