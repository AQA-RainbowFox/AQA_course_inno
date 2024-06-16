import io.qameta.allure.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.inno.course.helpers.ConfigHelper;
import ru.inno.course.network.NetworkService;
import ru.inno.course.pages.BookStorePage;
import ru.inno.course.pages.LoginPage;
import ru.inno.course.pages.MenuPage;
import ru.inno.course.pages.ProfilePage;

import java.time.Duration;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Book Store")
@Owner("Балашова Дарья")
@DisplayName("Тестирование Book Store")
public class BookStoreTest {

    private WebDriver driver;
    private NetworkService networkService;
    private LoginPage login;
    private ProfilePage profile;
    private BookStorePage bookStorePage;
    private MenuPage menu;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        login = new LoginPage(driver);
        profile = new ProfilePage(driver);
        bookStorePage = new BookStorePage(driver);
        menu = new MenuPage(driver);
        networkService = new NetworkService(ConfigHelper.getUserName(), ConfigHelper.getPassword());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            networkService = new NetworkService("RainbowFox", "Q123321q!");
            networkService.deleteAllBooksFromProfile();
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

    @Test
    @DisplayName("Отображение пустого профиля после успешной авторизации")
    @Description("После авторизации заходим в пустой профиль")
    @Severity(SeverityLevel.BLOCKER)
    @Tags(@Tag("Позитивный"))
    public void emptyProfileTest() {
        login.openPage();
        login.authOnBookStore(ConfigHelper.getUserName(), ConfigHelper.getPassword());

        step("Проверить, что в профиле нет книг", () -> assertEquals(ConfigHelper.getPageProfileRows(),
                profile.getPageContentInfo(),
                "В профиле есть книги, ожидалось, что их не будет"
        ));
    }

    @Test
    @DisplayName("Отображение добавленных в профиль книг")
    @Description("После авторизации добавляем книги, переходим в профиль и видим," +
            " что добавленные книги в нем отображаются")
    @Severity(SeverityLevel.CRITICAL)
    @Tags(@Tag("Позитивный"))
    public void bookAddProfileTest() {
        login.openPage();
        login.authOnBookStore(ConfigHelper.getUserName(), ConfigHelper.getPassword());
        menu.clickOnBookStore();

        networkService.addBookToProfile(bookStorePage.getAllIsbn(ConfigHelper.countBookAddProfileTest()));

        login.openPage();
        login.authOnBookStore(ConfigHelper.getUserName(), ConfigHelper.getPassword());

        step("Проверить, что ожидаемое и отображаемое количестов книг совпадают", () ->
                assertEquals(ConfigHelper.expectedCountBookAddProfileTest(),
                        profile.getBooksCount(),
                        "Ожидаемое и отображаемое количество книг не совпадают"
                )
        );
    }

    @Test
    @DisplayName("Успешное добавление книг в профиль и их удаление")
    @Description("После авторизации добавляем книги, переходим в профиль," +
            " видим, что книги в нем отображаются, затем удаляем книги," +
            " и после пререхода в профиль видим, что книги удалены")
    @Severity(SeverityLevel.CRITICAL)
    @Tags(@Tag("Позитивный"))
    public void bookAddAndDeleteTest() {
        SoftAssertions softy = new SoftAssertions();

        login.openPage();
        login.authOnBookStore(ConfigHelper.getUserName(), ConfigHelper.getPassword());
        menu.clickOnBookStore();

        networkService.addBookToProfile(bookStorePage.getAllIsbn(ConfigHelper.countBookAddAndDeleteTest()));

        login.openPage();
        login.authOnBookStore(ConfigHelper.getUserName(), ConfigHelper.getPassword());

        step("Проверить, что ожидаемое и отображаемое количество книг совпадают", () -> {
                    softy.assertThat(ConfigHelper.expectedCountBookAddAndDeleteTest())
                            .as("Ожидаемое и отображаемое количество книг не совпадают после добавления")
                            .isEqualTo(profile.getBooksCount());
                }
        );

        profile.clickDeleteAllBooks();

        step("Проверить, что в профиле нет книг после удаления", () -> {
                    softy.assertThat(ConfigHelper.getPageProfileRows())
                            .as("В профиле есть книги, ожидалось, что их не будет")
                            .isEqualTo(profile.getPageContentInfo());
                }
        );

        softy.assertAll();
    }
}
