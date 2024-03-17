package ru.inno.course;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class EmployeeContractTest {

    public static final String URL_employee = "https://x-clients-be.onrender.com/employee";
    public static final String URL_company = "https://x-clients-be.onrender.com/company";
    public static final String URL_AUTH = "https://x-clients-be.onrender.com/auth/login";

    public static String token;

    public static int companyId;
    public static int idEmployee;


    @BeforeEach
    public void setUp() {
        String creds = """
                {
                  "username": "leyla",
                  "password": "water-fairy"
                }
                """;

        //получение токена
        token = given()
                .body(creds)
                .contentType(ContentType.JSON)
                .when().post(URL_AUTH)
                .then()
                .statusCode(201)
                .extract().path("userToken");

        //создание компании
        String nameCompany = """
                {
                  "name": "fox&gogs",
                  "description": "лисы и собаки"
                }
                """;
        companyId = given()
                .body(nameCompany)
                .header("x-client-token", token)
                .contentType(ContentType.JSON)
                .when().post(URL_company)
                .then()
                .statusCode(201)
                .extract().path("id");
    }

    @AfterEach
    public void cleanUp() {
        given()
                .header("id", companyId)
                .header("x-client-token", token)
                .contentType(ContentType.JSON)
                .when().get(URL_company)
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Создание сотрудника")
    public void createEmployee() {
        String employerJson = """
                {
                  "firstName": "Jane",
                  "lastName": "Doe",
                  """ +
                "\"companyId\":" + companyId + "," +
                """
                        "email": "email@email.ru",
                        "phone": "81231232323",
                        "isActive": true
                            }
                                """;
        idEmployee = given()
                .body(employerJson)
                .header("x-client-token", token)
                .contentType(ContentType.JSON)
                .when().post(URL_employee)
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .extract().path("id");
    }

    @Test
    @DisplayName("Получение списка сотрудников и проверка наличия сотрудника")
    public void getAllEmployee() {
        createEmployee();

        given()
                .contentType(ContentType.JSON)
                .queryParam("company", companyId)
                .when().get(URL_employee)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(is(notNullValue()))
                .body("id", contains(idEmployee));
    }

    @Test
    @DisplayName("Получение сотрудника по id")
    public void getEmployeeById() {
        createEmployee();

        given()
                .contentType(ContentType.JSON)
                .when().get(URL_employee + "/" + idEmployee)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(is(notNullValue()));
    }

    @Test
    @DisplayName("Изменение информации о сотруднике и проверка сохранения изменений")
    public void patchEmployee() {
        createEmployee();

        String patchEmployerJson = """
                {
                  "email": "em@email.com",
                  "phone": "1234567890",
                  "isActive": true
                }
                """;

        given()
                .body(patchEmployerJson)
                .header("x-client-token", token)
                .contentType(ContentType.JSON)
                .when().patch(URL_employee + "/" + idEmployee)
                .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(is(notNullValue()))
                .body("email", equalTo("em@email.com"));
    }

}