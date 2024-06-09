package ru.inno.course.pages;

import org.openqa.selenium.*;

import java.util.List;

public class MenuPage {
    private final WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnBookStore(){
        //driver.findElements(By.cssSelector(".btn.btn-light")).get(30).click();

        WebElement menuItem = driver.findElement(By.cssSelector(".element-group:last-child #item-2"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", menuItem);
        menuItem.click();
    }
}
