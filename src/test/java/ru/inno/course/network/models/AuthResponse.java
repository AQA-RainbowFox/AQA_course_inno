package ru.inno.course.network.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class AuthResponse {

    @JsonProperty("userToken")
    private String userToken;
    @JsonProperty("role")
    private String role;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("login")
    private String login;

    public AuthResponse() {
    }

    public AuthResponse(String userToken, String role, String displayName, String login) {
        super();
        this.userToken = userToken;
        this.role = role;
        this.displayName = displayName;
        this.login = login;
    }

    @JsonProperty("userToken")
    public String getUserToken() {
        return userToken;
    }

    @JsonProperty("userToken")
    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("login")
    public String getLogin() {
        return login;
    }

    @JsonProperty("login")
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthResponse that)) return false;
        return Objects.equals(getUserToken(), that.getUserToken()) && Objects.equals(getRole(), that.getRole()) && Objects.equals(getDisplayName(), that.getDisplayName()) && Objects.equals(getLogin(), that.getLogin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserToken(), getRole(), getDisplayName(), getLogin());
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "userToken='" + userToken + '\'' +
                ", role='" + role + '\'' +
                ", displayName='" + displayName + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}