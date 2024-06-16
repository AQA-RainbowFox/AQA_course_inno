package ru.inno.course.network;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import ru.inno.course.helpers.ConfigHelper;
import ru.inno.course.network.models.BookItem;
import ru.inno.course.network.models.BooksRequest;
import ru.inno.course.network.models.LoginRequest;

import java.util.List;

import static io.restassured.RestAssured.given;

public class NetworkService {
    public String userId;
    String login;
    String password;

    public NetworkService(String login, String password) {
        this.login = login;
        this.password = password;
        getUserId();
    }

    private void getUserId() {
        userId = given()
                .body(new LoginRequest(login, password))
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post(ConfigHelper.getBaseUrl() + "/Account/v1/Login")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .path("userId");
    }

    @Step("Добавить переданное количество книг в \"Profle\" через API " +
            "методом POST https://demoqa.com/BookStore/v1/Books ")
    public void addBookToProfile(List<BookItem> listIsbn) {
        given()
                .auth()
                .preemptive()
                .basic(login, password)
                .body(new BooksRequest(userId, listIsbn))
                .header("Accept", "*/*")
                .contentType(ContentType.JSON)
                .when()
                .post(ConfigHelper.getBaseUrl() + "/BookStore/v1/Books");
    }

    public void deleteAllBooksFromProfile() {
        given()
                .auth()
                .preemptive()
                .basic(login, password)
                .header("Accept", "*/*")
                .contentType(ContentType.JSON)
                .when()
                .delete(ConfigHelper.getBaseUrl() + "/BookStore/v1/Books?UserId=" + userId);
    }
}
