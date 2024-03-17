package ru.inno.course.homework_19_lesson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import ru.inno.course.homework_19_lesson.model.Task;
import java.io.IOException;
import java.util.List;

public class TaskService {

    private final HttpClient client;
    private final String URL;

    public TaskService(String incomeUrl) {
        URL = incomeUrl;
        this.client = HttpClientBuilder.create().build();
    }

    public Task createNewTask(String title) throws IOException {
        String requestBody = "{\"title\":\"" + title + "\",\"completed\":false}";
        ObjectMapper mapper = new ObjectMapper();
        HttpPost createTask = new HttpPost(URL);
        StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
        createTask.setEntity(entity);

        HttpResponse response = client.execute(createTask);
        String responseBody = EntityUtils.toString(response.getEntity());
        return mapper.readValue(responseBody, Task.class);
    }

    public List<Task> getTaskList() throws IOException {
        HttpGet getAll = new HttpGet(URL);
        HttpResponse taskList = client.execute(getAll);
        String responseBody = EntityUtils.toString(taskList.getEntity());
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, new TypeReference<>() {
        });
    }

    public Task getTaskById(int id) throws IOException {
        HttpGet getTask = new HttpGet(URL + id);
        HttpResponse task = client.execute(getTask);
        String responseBody = EntityUtils.toString(task.getEntity());
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Task.class);
    }

    public void deleteAllTasks() throws IOException {
        HttpDelete deleteAll = new HttpDelete(URL);
        client.execute(deleteAll);
    }

    public int deleteOneTask(int id) throws IOException {
        HttpDelete deleteOneTask = new HttpDelete(URL + id);
        HttpResponse response = client.execute(deleteOneTask);
        return response.getStatusLine().getStatusCode();
    }


    public Task updateTitleTask(String title, int id) throws IOException {
        String requestBody = "{\"title\":\"" + title + "\"}";
        ObjectMapper mapper = new ObjectMapper();
        HttpPatch updateTask = new HttpPatch(URL + id);
        StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
        updateTask.setEntity(entity);

        HttpResponse response = client.execute(updateTask);
        String responseBody = EntityUtils.toString(response.getEntity());
        return mapper.readValue(responseBody, Task.class);
    }

    public Task completedTask(int id, boolean isComplete) throws IOException {
        String requestBody = "{\"completed\":" + isComplete + "}";
        ObjectMapper mapper = new ObjectMapper();
        HttpPatch completedTask = new HttpPatch(URL + id);
        StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
        completedTask.setEntity(entity);

        HttpResponse response = client.execute(completedTask);
        String responseBody = EntityUtils.toString(response.getEntity());
        return mapper.readValue(responseBody, Task.class);
    }


}
