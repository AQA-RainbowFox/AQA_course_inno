package ru.inno.course;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.*;
import ru.inno.course.db.DbService;
import ru.inno.course.network.NetworkService;
import ru.inno.course.network.models.EmployeeResponse;
import ru.inno.course.utils.AttachmentHelper;
import ru.inno.course.utils.ConfigHelper;
import ru.inno.course.utils.Utils;

import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Epic("x-clients-be.onrender.com")
@Feature("Employee")
@Owner("Балашова Дарья")
@DisplayName("Тестирование методов работы с сотрудниками сервиса x-clients-be.onrender.com")
public class EmployeeBusinessTest {
    private static NetworkService networkService;
    private static DbService dbService;
    private int companyId;
    private String firstName;
    private static String adminName;

    @BeforeAll
    public static void init() throws SQLException {
        dbService = new DbService();
        String adminPassword;

        if (ConfigHelper.getUserName().isEmpty() || ConfigHelper.getPassword().isEmpty()) {
            adminName = Utils.generateFirstName();
            adminPassword = Utils.generateAlphabetic(6);
            dbService.createAdmin(adminName, adminPassword, adminName);
        } else {
            adminName = ConfigHelper.getUserName();
            adminPassword = ConfigHelper.getPassword();
        }

        networkService = new NetworkService(adminName, adminPassword);
    }

    @BeforeEach
    public void setup() {
        companyId = networkService.createCompany(Utils.generateAlphabetic(10));
        firstName = Utils.generateFirstName();

        for (int i = 0; i < 3; i++) {
            networkService.createEmployee(companyId,
                    Utils.generateFirstName(),
                    Utils.generateLastName(),
                    Utils.generateEmail(),
                    Utils.generatePhone()
            );
        }
    }

    @Test
    @DisplayName("Сотрудника нельзя создать для несуществующей компании")
    @Description("В ответе на запрос POST/employee с невалидным полем \"companyId\" приходит ошибка")
    @Severity(SeverityLevel.NORMAL)
    @Tags({@Tag("Employee"), @Tag("Negative")})
    public void nonExistCompanyCreateEmployee() {
        SoftAssertions assertions = new SoftAssertions();

        step("Запрос на создание нового сотрудника", () -> {
            Response response = networkService.createEmployeeRequest(Integer.MAX_VALUE,
                            firstName,
                            Utils.generateLastName(),
                            Utils.generateEmail(),
                            Utils.generatePhone()
                    )
                    .then()
                    .extract()
                    .response();

            assertions.assertThat(response.statusCode()).isEqualTo(400);
        });

        Awaitility.await()
                .atMost(Duration.ofSeconds(3))
                .pollInterval(Duration.ofMillis(100))
                .until(() -> !dbService.checkEmployeeFirstNameExist(firstName));

        step("Проверка, что сотрудника не существует в БД", () -> {
            assertions
                    .assertThat(!dbService.checkEmployeeFirstNameExist(firstName))
                    .as("В базе данных есть сотрудник");
        });

        assertions.assertAll();
    }

    @Test
    @DisplayName("Неактивный сотрудник не отображается в списке сотрудников компании")
    @Description("В ответе на запрос GET/employee сотрудник со параметром \"isActive\": false не отображается")
    @Severity(SeverityLevel.NORMAL)
    @Tags({@Tag("Employee"), @Tag("Positive")})
    public void unActiveEmployeeNotGet() {
        int employeeId = networkService.createEmployee(companyId,
                firstName,
                Utils.generateLastName(),
                Utils.generateEmail(),
                Utils.generatePhone()
        );

        networkService.patchEmployeeById(employeeId, ConfigHelper.employeeActiveFlag());
        List<EmployeeResponse> employs = networkService.getEmploysByCompanyId(companyId);

        AttachmentHelper.attachText("Список сотрудников", employs.toString());

        for (EmployeeResponse employee : employs) {
            assertNotEquals(
                    employee.getFirstName(),
                    firstName,
                    "В ответе от сервера есть неактивный сотрудник с именем " + firstName
            );
        }
    }

    @AfterEach
    public void cleanUp() throws SQLException {
        dbService.deleteEmployeeByCompanyId(companyId);
        dbService.deleteCompanyById(companyId);
    }

    @AfterAll
    public static void finish() throws SQLException {
        if (ConfigHelper.getUserName().isEmpty() || ConfigHelper.getPassword().isEmpty()) {
            dbService.deleteAdmin(adminName);
        }
        dbService.disconnect();
    }
}
