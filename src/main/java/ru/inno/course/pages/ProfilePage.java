package ru.inno.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(){
        driver.get("https://demoqa.com/profile");
    }
    public void clickLogOut(){
        driver.findElement(By.cssSelector("div[class='text-right col-md-5 col-sm-12'] #submit")).click();
    }
    public void clickDeleteAllBooks(){
        driver.findElement(By.cssSelector("div[class='text-right button di'] #submit")).click();
        driver.findElement(By.cssSelector("#closeSmallModal-ok")).click();
        driver.switchTo().alert().accept();
    }
}
