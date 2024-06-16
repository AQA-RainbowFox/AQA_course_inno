package ru.inno.course.pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.inno.course.helpers.ConfigHelper;

import java.time.Duration;

public class ProfilePage {
    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на \"Delete All Books\" на странице \"Profile\"")
    public void clickDeleteAllBooks() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement btnDelete = driver.findElement(By.cssSelector("div[class='text-right button di'] #submit"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", btnDelete);
        btnDelete.click();
        driver.findElement(By.cssSelector("#closeSmallModal-ok")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.navigate().refresh();
        getPageScreen();

    }

    @Step("Получить статус, что страница \"Profile\" не содержит книг")
    public String getPageContentInfo() {
        String text = driver.findElement(By.cssSelector(".rt-noData")).getText();
        getPageScreen();
        return text;
    }

    @Step("Получить количество книг в \"Profile\"")
    public int getBooksCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("span.select-wrap.-pageSizeOptions select[aria-label='rows per page']")
                )
        );
        Select select = new Select(dropdown);
        select.selectByValue(ConfigHelper.countDropDownMenu());
        int size = driver.findElements(By.cssSelector("a[href^='/profile?book']")).size();
        getPageScreen();
        return size;
    }

    @Attachment(value = "ScreenShot.png", fileExtension = ".png", type = "image/png")
    private byte[] getPageScreen() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
