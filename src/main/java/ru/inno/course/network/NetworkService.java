package ru.inno.course.network;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import ru.inno.course.network.models.*;
import ru.inno.course.utils.ConfigHelper;

import java.util.List;

import static io.restassured.RestAssured.given;

public class NetworkService {
    private String token;
    private int companyId;
    private int employeeId;

    public NetworkService(String userName, String password) {
        token = given()
                .baseUri(ConfigHelper.getBaseUrl())
                .body(new AuthRequest(userName, password))
                .contentType(ContentType.JSON)
                .when()
                .post(ConfigHelper.getAuthPath())
                .then()
                .extract()
                .path("userToken");
    }
    @Step("Создать компанию через API")
    public int createCompany(String companyName) {
        companyId = given()
                .baseUri(ConfigHelper.getBaseUrl())
                .body(new CompanyRequest(companyName))
                .header(ConfigHelper.getTokenHeader(), token)
                .contentType(ContentType.JSON)
                .when()
                .post(ConfigHelper.getCompanyPath())
                .then()
                .extract()
                .path("id");
        return companyId;
    }
    @Step("Получить список компаний с фильтром по isActive через API")
    public List<CompanyResponse> getFilteredAllCompany(boolean isActive) {
        return given()
                .baseUri(ConfigHelper.getBaseUrl())
                .queryParam(ConfigHelper.companyActiveParam(), isActive)
                .contentType(ContentType.JSON)
                .when()
                .get(ConfigHelper.getCompanyPath())
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .body()
                .jsonPath()
                .getList(".", CompanyResponse.class);

    }
    @Step("Удалить компании через API")
    public void deleteCompany(int companyId) {
        given()
                .baseUri(ConfigHelper.getBaseUrl())
                .contentType(ContentType.JSON)
                .header(ConfigHelper.getTokenHeader(), token)
                .when()
                .get(ConfigHelper.getCompanyDeletePath() + "/" + companyId)
                .then()
                .contentType(ContentType.JSON);
    }
    @Step("Создать сотрудника через API")
    public int createEmployee(int companyId,
                              String name,
                              String lastName,
                              String email,
                              String phone
    ) {
        employeeId = given()
                .baseUri(ConfigHelper.getBaseUrl())
                .body(
                        new EmployeeRequest(
                                name,
                                lastName,
                                companyId,
                                email,
                                phone
                        )
                )
                .header(ConfigHelper.getTokenHeader(), token)
                .contentType(ContentType.JSON)
                .when()
                .post(ConfigHelper.getEmployeePath())
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .path("id");
        return employeeId;
    }

    @Step("Сформировать запрос на создание сотрудника через API")
    public Response createEmployeeRequest(int companyId,
                                   String name,
                                   String lastName,
                                   String email,
                                   String phone
    ) {
        return given()
                .baseUri(ConfigHelper.getBaseUrl())
                .body(
                        new EmployeeRequest(
                                name,
                                lastName,
                                companyId,
                                email,
                                phone
                        )
                )
                .header(ConfigHelper.getTokenHeader(), token)
                .contentType(ContentType.JSON)
                .when()
                .post(ConfigHelper.getEmployeePath());
    }
    @Step("Получить список сотрудников для компании через API")
    public List<EmployeeResponse> getEmploysByCompanyId(int companyId) {
        return given()
                .baseUri(ConfigHelper.getBaseUrl())
                .queryParam("company", String.valueOf(companyId))
                .contentType(ContentType.JSON)
                .when()
                .get(ConfigHelper.getEmployeePath())
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .body()
                .jsonPath()
                .getList(".", EmployeeResponse.class);
    }
    @Step("Изменить статус сотрудника через API")
    public void patchEmployeeById(int employeeId, boolean isActive) {
        given()
                .baseUri(ConfigHelper.getBaseUrl())
                .body(new EmployeePatchRequest(isActive))
                .header(ConfigHelper.getTokenHeader(), token)
                .contentType(ContentType.JSON)
                .when()
                .patch(ConfigHelper.getEmployeePath() + "/" + employeeId)
                .then()
                .contentType(ContentType.JSON);
    }
}
