package ru.inno.course.network.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeePatchRequest {

    @JsonProperty("isActive")
    private boolean isActive;

    public EmployeePatchRequest(boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("isActive")
    public boolean isActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setActive(boolean active) {
        isActive = active;
    }
}
