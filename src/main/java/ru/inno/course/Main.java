package ru.inno.course;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.inno.course.pages.LoginPage;
import ru.inno.course.pages.MenuPage;
import ru.inno.course.pages.ProfilePage;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //        "rt-noData">No rows found</
        //       WebDriverWait wait = new WebDriverWait(driver, ofSeconds(30));
        //        wait.until(ExpectedConditions.attributeToBe(progressBar,"aria-valuenow", "75"));
        String user = "RainbowFox";
        String pass = "Q123321q!";
        WebDriver driver;
        LoginPage login;
        MenuPage menu;
        ProfilePage profile;
        driver = new ChromeDriver();
        login = new LoginPage(driver);
        profile = new ProfilePage(driver);
        menu = new MenuPage(driver);

        login.openPage();
        login.setLogin(user);
        login.setPassword(pass);
        login.clickLogin();
        Thread.sleep(5000);
        profile.clickDeleteAllBooks();
        menu.clickOnBookStore();
        driver.quit();
    }
}
