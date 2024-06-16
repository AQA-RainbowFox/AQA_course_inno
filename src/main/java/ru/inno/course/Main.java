package ru.inno.course;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.inno.course.network.NetworkService;
import ru.inno.course.pages.BookStorePage;
import ru.inno.course.pages.LoginPage;
import ru.inno.course.pages.MenuPage;
import ru.inno.course.pages.ProfilePage;

import java.time.Duration;

//public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        // "rt-noData">No rows found</
//        //       WebDriverWait wait = new WebDriverWait(driver, ofSeconds(30));
//        //        wait.until(ExpectedConditions.attributeToBe(progressBar,"aria-valuenow", "75"));
//        String user = "RainbowFox";
//        String pass = "Q123321q!";
//        WebDriver driver;
//        LoginPage login;
//        MenuPage menu;
//        BookStorePage bookStorePage;
//        ProfilePage profile;
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//        login = new LoginPage(driver);
//        profile = new ProfilePage(driver);
//        menu = new MenuPage(driver);
//        bookStorePage = new BookStorePage(driver);
//
//        login.openPage();
//        login.authOnBookStore(user, pass);
//
//
//        menu.clickOnBookStore();
//
//        NetworkService ns = new NetworkService(user, pass);
//        ns.addBookToProfile(bookStorePage.getAllIsbn(6));
//
////        profile.openPage();
//        login.openPage();
//        login.authOnBookStore(user, pass);
//
//
////        profile.clickAndSelectDropDownMenu();
////        System.out.println(profile.getBooksCount());
//         profile.clickDeleteAllBooks();
//
//        //System.out.println(profile.getPageContentInfo());
//        driver.quit();
//    }
//}
