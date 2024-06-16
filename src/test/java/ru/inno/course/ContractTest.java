package ru.inno.course;

import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import ru.inno.course.db.DbService;
import ru.inno.course.network.models.AuthRequest;
import ru.inno.course.network.models.CompanyRequest;
import ru.inno.course.network.models.EmployeeRequest;
import ru.inno.course.utils.ConfigHelper;
import ru.inno.course.utils.Utils;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Epic("x-clients-be.onrender.com")
@Feature("Contract")
@Owner("Балашова Дарья")
@DisplayName("Positive contract test для сервиса x-clients-be.onrender.com")
public class ContractTest {

    private static DbService dbService;
    private String token;
    private int companyId;
    private static String adminName;
    private static String adminPassword;

    @BeforeAll
    public static void createAdmin() throws SQLException {
        dbService = new DbService();

        if (ConfigHelper.getUserName().isEmpty() || ConfigHelper.getPassword().isEmpty()) {
            adminName = Utils.generateFirstName();
            adminPassword = Utils.generateAlphabetic(6);
            dbService.createAdmin(adminName, adminPassword, adminName);
        } else {
            adminName = ConfigHelper.getUserName();
            adminPassword = ConfigHelper.getPassword();
        }

    }

    @BeforeEach
    public void setup() {
        String randomCompanyName = RandomStringUtils.randomAlphabetic(10).toLowerCase();

        token = given()
                .baseUri(ConfigHelper.getBaseUrl())
                .body(new AuthRequest(adminName, adminPassword))
                .contentType(ContentType.JSON)
                .when()
                .post(ConfigHelper.getAuthPath())
                .then()
                .extract()
                .path("userToken");

        companyId = given()
                .baseUri(ConfigHelper.getBaseUrl())
                .body(new CompanyRequest(randomCompanyName))
                .header(ConfigHelper.getTokenHeader(), token)
                .contentType(ContentType.JSON)
                .when()
                .post(ConfigHelper.getCreateCompanyPath())
                .then()
                .extract()
                .path("id");
    }

    @Test
    @DisplayName("Проверка позитивного ответа на запрос авторизации")
    @Description("""
            ### В ответ на запрос авторизации приходит:
            #### Headers
            - Status Code: 201
            - ContentType: json
                        
            #### Body
            - userToken
            - role
            - displayName
            - login""")
    @Severity(SeverityLevel.BLOCKER)
    @Tags({@Tag("Authorization"), @Tag("Positive")})
    public void checkAuthResponse() {
        given()
                .baseUri(ConfigHelper.getBaseUrl())
                .body(new AuthRequest(adminName, adminPassword))
                .contentType(ContentType.JSON)
                .when()
                .post(ConfigHelper.getAuthPath())
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("$", hasKey("userToken"))
                .body("$", hasKey("role"))
                .body("$", hasKey("displayName"))
                .body("$", hasKey("login"));
    }

    @Test
    @DisplayName("Проверка ответа на запрос создания компании")
    @Description("""
            ### В ответ на запрос создания компании приходит:
            #### Headers
            - Status Code: 201
            - ContentType: json
            
            #### Body
            - id""")
    @Severity(SeverityLevel.MINOR)
    @Tags({@Tag("Company"), @Tag("Positive")})
    public void checkCreateCompanyResponse() throws SQLException {
        String randomCompanyName = RandomStringUtils.randomAlphabetic(10).toLowerCase();

        int id = given()
                .baseUri(ConfigHelper.getBaseUrl())
                .body(new CompanyRequest(randomCompanyName))
                .header(ConfigHelper.getTokenHeader(), token)
                .contentType(ContentType.JSON)
                .when()
                .post(ConfigHelper.getCreateCompanyPath())
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("$", hasKey("id"))
                .extract()
                .path("id");

        dbService.deleteCompanyById(id);
    }

    @Test
    @DisplayName("Проверка ответа на запрос получения списка компаний")
    @Description("""
            ### В ответ на запрос получения компании приходит:
            #### Headers
            - Status Code: 200
            - ContentType: json
            
            #### Body
            - id
            - isActive
            - createDateTime
            - lastChangedDateTime
            - name
            - description
            - deletedAt""")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("Company"), @Tag("Positive")})
    public void checkCorrectGetAllCompanyResponse() {
        given()
                .baseUri(ConfigHelper.getBaseUrl())
                .queryParam(ConfigHelper.companyActiveParam(), ConfigHelper.companyActiveFlag())
                .contentType(ContentType.JSON)
                .when()
                .get(ConfigHelper.getCompanyPath())
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("$", everyItem(
                        allOf(
                                hasKey("id"),
                                hasKey("isActive"),
                                hasKey("createDateTime"),
                                hasKey("lastChangedDateTime"),
                                hasKey("name"),
                                hasKey("description"),
                                hasKey("deletedAt")
                        )));
    }

    @Test
    @DisplayName("Проверка ответа на запрос создания сотрудника")
    @Description("""
            ### В ответ на запрос получения компании приходит:
            #### Headers
            - Status Code: 201
            - ContentType: json
            
            #### Body
            - id""")
    @Severity(SeverityLevel.NORMAL)
    @Tags({@Tag("Employee"), @Tag("Positive")})
    public void checkCreateEmployeeResponse() throws SQLException {
        int employeeId = given()
                .baseUri(ConfigHelper.getBaseUrl())
                .body(
                        new EmployeeRequest(
                                Utils.generateFirstName(),
                                Utils.generateLastName(),
                                companyId,
                                Utils.generateEmail(),
                                Utils.generatePhone()
                        )
                )
                .header(ConfigHelper.getTokenHeader(), token)
                .contentType(ContentType.JSON)
                .when()
                .post(ConfigHelper.getEmployeePath())
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("$", hasKey("id"))
                .extract()
                .path("id");

        dbService.deleteEmployeeById(employeeId);
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
