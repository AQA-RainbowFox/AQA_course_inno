package ru.inno.course.network.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyResponse {

    @JsonProperty("id")
    private int id;

    public CompanyResponse() {
    }

    public CompanyResponse(int id) {
        this.id = id;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CompanyResponse{" +
                "id=" + id +
                '}';
    }
}