package ru.inno.course.network.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyRequest {
    @JsonProperty("name")
    private String name;

    public CompanyRequest(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
