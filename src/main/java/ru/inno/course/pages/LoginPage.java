package ru.inno.course.pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.inno.course.helpers.ConfigHelper;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу https://demoqa.com/login")
    public void openPage() {
        driver.manage().window().maximize();
        driver.get(ConfigHelper.getBaseUrl() + "/login");
    }

    @Step("Авторизация на странице https://demoqa.com/login")
    public void authOnBookStore(String user, String password) {
        setUserName(user);
        setPassword(password);
        clickLogInBtn();
    }

    @Step("Ввести логин в поле \"UserName\"")
    private void setUserName(String user) {
        driver.findElement(By.cssSelector("#userName")).sendKeys(user);
    }

    @Step("Ввести пароль в поле \"Password\"")
    private void setPassword(String password) {
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
    }

    @Step("Нажать на кнопку \"Login\"")
    private void clickLogInBtn() {
        driver.findElement(By.cssSelector("#login")).click();
        getPageScreen();
    }

    @Attachment(value = "ScreenShot.png", fileExtension = ".png", type = "image/png")
    private byte[] getPageScreen() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

