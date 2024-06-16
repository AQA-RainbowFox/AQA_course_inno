package ru.inno.course.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.inno.course.network.models.BookItem;

import java.util.ArrayList;
import java.util.List;

public class BookStorePage {
    private final WebDriver driver;

    public BookStorePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Получить заданное количество книг со страницы https://demoqa.com/books")
    public List<BookItem> getAllIsbn(int countOfBooks) {
        List<WebElement> element = driver.findElements(By.cssSelector("a[href^='/books']"));
        List<BookItem> resultIsbn = new ArrayList<>();

        for (int i = 0; i < countOfBooks; i++) {
            resultIsbn.add(new BookItem(element.get(i).getAttribute("href").split("=")[1]));
        }

        return resultIsbn;
    }
}
