package ru.inno.course.homework_19_lesson;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApacheHttpContractTests {

    private HttpClient client;
    public static final String URL = "https://todo-app-sky.herokuapp.com/";

    @BeforeEach
    public void setupHttpClient() {
        client = HttpClientBuilder.create().build();
    }

    @Test
    @DisplayName("Получение списка задач. Проверка статус кода и заголовка Content-Type")
    public void contentTypeShouldBeJson() throws IOException {
        HttpGet getRequest = new HttpGet(URL);

        HttpResponse response = client.execute(getRequest);
        Header contentTypeHeader = response.getFirstHeader("Content-Type");

        assertEquals(200, response.getStatusLine().getStatusCode());
        assertTrue(response.containsHeader("Content-Type"));
        assertTrue(contentTypeHeader.getValue().contains("application/json"));
    }

    @Test
    @DisplayName("Создание задачи. Проверка статус кода, заголовка Content-Type и тела ответа в формате json")
    public void canCreateTask() throws IOException {
        String requestBody = "{\"title\":\"Создать задачу\",\"completed\":false}";

        HttpPost createTask = new HttpPost(URL);
        createTask.setEntity(new StringEntity(requestBody));

        HttpResponse response = client.execute(createTask);
        String responseBody = EntityUtils.toString(response.getEntity());
        Header contentTypeHeader = response.getFirstHeader("Content-Type");

        assertEquals(201, response.getStatusLine().getStatusCode());
        assertTrue(response.containsHeader("Content-Type"));
        assertTrue(contentTypeHeader.getValue().contains("application/json"));
        assertTrue(responseBody.contains("Создать задачу"));
    }

}
