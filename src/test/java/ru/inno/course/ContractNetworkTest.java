package ru.inno.course;

import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.junit.jupiter.api.*;
import ru.inno.course.db.DbService;
import ru.inno.course.network.models.AuthRequest;
import ru.inno.course.network.models.CompanyRequest;
import ru.inno.course.network.models.EmployeeRequest;
import java.net.URISyntaxException;
import java.sql.SQLException;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class ContractNetworkTest {
    private final String URL = "https://x-clients-be.onrender.com/";
    private static final String USERNAME = "admin_rainbow";
    private static final String PASSWORD = "Fox-fox";
    private static final String DISPLAY_NAME = "admin_rainbow";
    private final String HEADER_FOR_TOKEN = "x-client-token";
    private String token;
    private int companyId;
    private int employeeId;

    @BeforeAll
    // Создание админа
    public static void createAdmin() throws SQLException {
        new DbService().createAdmin(USERNAME, PASSWORD, DISPLAY_NAME);
    }

    @BeforeEach
    // авторизация и создание компании
    public void setUP() throws URISyntaxException {
        String randomCompanyName = RandomStringUtils.randomAlphabetic(10).toLowerCase();
        String authUrl = new URIBuilder(URL).setPath("/auth/login").build().toString();
        String createCompanyUrl = new URIBuilder(URL).setPath("/company").build().toString();

        token = given()
                .body(new AuthRequest(USERNAME, PASSWORD))
                .contentType(ContentType.JSON)
                .when()
                .post(authUrl)
                .then()
                .statusCode(201)
                .extract()
                .path("userToken");

        companyId = given()
                .body(new CompanyRequest(randomCompanyName))
                .header(HEADER_FOR_TOKEN, token)
                .contentType(ContentType.JSON)
                .when()
                .post(createCompanyUrl)
                .then()
                .statusCode(201)
                .extract()
                .path("id");

    }

    @AfterEach
    // Удаление всех сотрудников с ключом company_id и удаление компании
    public void cleanUp() throws SQLException {
        DbService dbService = new DbService();
        dbService.deleteEmployee(companyId);
        dbService.deleteCompany(companyId);
        dbService.disconnect();
    }

    @AfterAll
    // удаление admin по ключу adminLogin
    public static void deleteAdmin() throws SQLException {
        new DbService().deleteAdmin(USERNAME);
    }

    @Test
    @DisplayName("Создание сотрудника")
    public void createEmployee() throws URISyntaxException {
        String employeeUrl = new URIBuilder(URL).setPath("/employee").build().toString();
        String randomFirstName = RandomStringUtils.randomAlphabetic(6).toLowerCase();
        String randomLastName = RandomStringUtils.randomAlphabetic(8).toLowerCase();
        String randomEmail = RandomStringUtils.randomAlphabetic(4).toLowerCase() + "@" + RandomStringUtils.randomAlphabetic(4).toLowerCase() + ".ru";
        String randomPhone = "+" + RandomStringUtils.randomNumeric(11);

        EmployeeRequest employeeRequest = new EmployeeRequest(randomFirstName, randomLastName, companyId, randomEmail, randomPhone);
        employeeId = given()
                .body(employeeRequest)
                .header(HEADER_FOR_TOKEN, token)
                .contentType(ContentType.JSON)
                .when()
                .post(employeeUrl)
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .extract().path("id");
    }

    @Test
    @DisplayName("Получение сотрудника по id и проверка статускода")
    public void getEmployeeById() throws URISyntaxException {
        createEmployee();
        String getEmployeeUrl = new URIBuilder(URL).setPath("/employee/" + employeeId).build().toString();

        given()
                .when().get(getEmployeeUrl)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(is(notNullValue()));
    }

    @Test
    @DisplayName("Получение списка сотрудников и проверка статускода и наличия сотрудника")
    public void getAllEmployee() throws URISyntaxException {
        createEmployee();
        String getAllEmployeeUrl = new URIBuilder(URL).setPath("/employee/").build().toString();

        given()
                .contentType(ContentType.JSON)
                .queryParam("company", companyId)
                .when().get(getAllEmployeeUrl)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(is(notNullValue()))
                .body("id", contains(employeeId));
    }

    @Test
    @DisplayName("Изменение информации о сотруднике и проверка статускода")
    public void patchEmployee() throws URISyntaxException {
        createEmployee();
        String patchEmployeeUrl = new URIBuilder(URL).setPath("/employee/" + employeeId).build().toString();
        String randomEmail = RandomStringUtils.randomAlphabetic(4).toLowerCase() + "@" + RandomStringUtils.randomAlphabetic(4).toLowerCase() + ".ru";
        String randomPhone = "+" + RandomStringUtils.randomNumeric(11);

        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setEmail(randomEmail);
        employeeRequest.setPhone(randomPhone);

        given()
                .body(employeeRequest)
                .header(HEADER_FOR_TOKEN, token)
                .contentType(ContentType.JSON)
                .when().patch(patchEmployeeUrl)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(is(notNullValue()));
    }

}
