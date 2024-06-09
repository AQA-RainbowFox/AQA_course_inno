package ru.inno.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(){
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
    }
    public void setLogin(String user){
        driver.findElement(By.cssSelector("#userName")).sendKeys(user);
    }
    public void setPassword(String password){
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(By.cssSelector("#login")).click();
    }

}
