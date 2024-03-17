package ru.inno.course.homework_19_lesson;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.inno.course.homework_19_lesson.model.Task;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ApacheHttpBusinessTests {

    private TaskService taskService;
    public static final String URL = "https://todo-app-sky.herokuapp.com/";

    @BeforeEach
    public void setUpService() {
        taskService = new TaskService(URL);
    }

    @AfterEach
    public void cleanUpEach() throws IOException {
        taskService.deleteAllTasks();
    }

    @Test
    @DisplayName("Создание задачи и проверка ее наличия в списке задач")
    public void createTask() throws IOException {
        Task task = taskService.createNewTask("Создать задачу");
        List<Task> tasks = taskService.getTaskList();
        assertTrue(tasks.contains(task));
    }

    @Test
    @DisplayName("Создание задачи и проверка ее получения по id")
    public void checkTaskById() throws IOException {
        Task task = taskService.createNewTask("Создать задачу");
        assertEquals(task, taskService.getTaskById(task.getId()));
    }

    @Test
    @DisplayName("Создание двух задач  и проверка наличия их в списке задач")
    public void createTwoTasks() throws IOException {
        Task task = taskService.createNewTask("Создать задачу");
        Task task1 = taskService.createNewTask("Создать задачу еще одну");
        List<Task> tasks = taskService.getTaskList();
        assertTrue(tasks.contains(task) && tasks.contains(task1));
    }

    @Test
    @DisplayName("Переименование задачи и проверка, что ее имя поменялось в получаемом списке задач")
    public void renameTask() throws IOException {
        Task task = taskService.createNewTask("Задача");
        Task newTask = taskService.updateTitleTask("Задача переименована", task.getId());
        assertEquals("Задача переименована", newTask.getTitle());
    }

    @Test
    @DisplayName("Пометка задачи сделанной и проверка, что в списке задач она отмечена выполненной")
    public void completeTask() throws IOException {
        Task task = taskService.createNewTask("Задача выполнена");
        Task newTask = taskService.completedTask(task.getId(), true);
        assertTrue(newTask.isCompleted());
    }

    @Test
    @DisplayName("Удаление задачи и проверка, что такой задачи в списке нет")
    public void deleteTask() throws IOException {
        Task task = taskService.createNewTask("Задача на удаление");
        int statusCode = taskService.deleteOneTask(task.getId());
        List<Task> tasks = taskService.getTaskList();
        assertEquals(204, statusCode);
        assertFalse(tasks.contains(task));
    }

}