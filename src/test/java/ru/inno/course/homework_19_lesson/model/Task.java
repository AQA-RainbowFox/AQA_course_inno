package ru.inno.course.homework_19_lesson.model;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class Task {
    private int id;
    private String title;
    private boolean completed;
    private int order;
    private String url;

    @ConstructorProperties({"id", "title", "completed", "order", "url"})
    public Task(int id, String title, boolean completed, int order, String url) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.order = order;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", order=" + order +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return getId() == task.getId() && isCompleted() == task.isCompleted() && getOrder() == task.getOrder() && Objects.equals(getTitle(), task.getTitle()) && Objects.equals(getUrl(), task.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), isCompleted(), getOrder(), getUrl());
    }
}
