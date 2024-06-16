package ru.inno.course.network.models;

import java.util.Objects;

public class LoginResponse {

    private String userId;
    private String username;

    private String password;

    public LoginResponse(String userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof LoginResponse that)) return false;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getUsername(),
                that.getUsername()) && Objects.equals(getPassword(), that.getPassword()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUsername(), getPassword());
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
