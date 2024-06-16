package ru.inno.course;

import io.qameta.allure.*;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.*;
import ru.inno.course.db.DbService;
import ru.inno.course.db.models.CompanyDb;
import ru.inno.course.network.NetworkService;
import ru.inno.course.network.models.CompanyResponse;
import ru.inno.course.utils.AttachmentHelper;
import ru.inno.course.utils.ConfigHelper;
import ru.inno.course.utils.Utils;

import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("x-clients-be.onrender.com")
@Feature("Company")
@Owner("Балашова Дарья")
@DisplayName("Тестирование методов работы с компаниями сервиса x-clients-be.onrender.com")
public class CompanyBusinessTests {

    private static NetworkService networkService;
    private static DbService dbService;
    private static final String firstCompanyName = Utils.generateAlphabetic(6);
    private static final String secondCompanyName = Utils.generateAlphabetic(6);
    private static final String thirdCompanyName = Utils.generateAlphabetic(6);
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
        dbService.createCompany(true, firstCompanyName, Utils.generateAlphabetic(20));
        dbService.createCompany(true, secondCompanyName, Utils.generateAlphabetic(20));
        dbService.createCompany(true, thirdCompanyName, Utils.generateAlphabetic(20));
    }

    @Test
    @DisplayName("Фильтрация списка компаний по параметру \"isActive=true\"")
    @Description("В ответе на запрос GET/company с параметром \"isActive=true\" находятся только активные компании ")
    @Severity(SeverityLevel.NORMAL)
    @Tags({@Tag("Company"), @Tag("Positive")})
    public void filterActiveParams() {
        List<CompanyResponse> companyList = networkService.getFilteredAllCompany(ConfigHelper.companyActiveFlag());

        AttachmentHelper.attachText("Список компаний", companyList.toString());
        for (CompanyResponse company : companyList) {
            assertTrue(company.isActive(), "Company has wrong isActive flag: " + company);
        }
    }

    @Test
    @DisplayName("В БД у удаленной комапнии компании поле \"deletedAt\" не пустое")
    @Description("После удаления компании через API в БД проверяем, что поле \"deletedAt\" не пустое")
    @Severity(SeverityLevel.NORMAL)
    @Tags({@Tag("Company"), @Tag("Positive")})
    public void checkFieldCompanyDeletedAt() {
        int companyId = networkService.createCompany(Utils.generateAlphabetic(10));
        networkService.deleteCompany(companyId);
        step("Ожидание обновления данных в БД, проверяем наличие записи в поле \"deletedAt\"", () -> {
            Awaitility.await()
                    .atMost(Duration.ofSeconds(3))
                    .pollInterval(Duration.ofMillis(100))
                    .until(() -> {
                        CompanyDb company = dbService.getCompanyById(companyId);
                        return company != null && company.getDeletedAt() != null;
                    });

            CompanyDb company = dbService.getCompanyById(companyId);
            AttachmentHelper.attachText("Информация о компании из БД", company.toString());
            assertNotNull(company.getDeletedAt(), company.toString());
        });
    }

    @AfterAll
    public static void finish() throws SQLException {
        dbService.deleteCompanyByName(firstCompanyName);
        dbService.deleteCompanyByName(secondCompanyName);
        dbService.deleteCompanyByName(thirdCompanyName);
        if (ConfigHelper.getUserName().isEmpty() || ConfigHelper.getPassword().isEmpty()) {
            dbService.deleteAdmin(adminName);
        }
        dbService.disconnect();
    }
}
