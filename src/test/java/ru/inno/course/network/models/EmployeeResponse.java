package ru.inno.course.network.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class EmployeeResponse {

    @JsonProperty("id")
    private int id;
    @JsonProperty("isActive")
    private boolean isActive;
    @JsonProperty("createDateTime")
    private String createDateTime;
    @JsonProperty("lastChangedDateTime")
    private String lastChangedDateTime;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("email")
    private String email;
    @JsonProperty("birthdate")
    private String birthdate;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("companyId")
    private int companyId;
    @JsonProperty("url")
    private String url;

    public EmployeeResponse() {
    }

    public EmployeeResponse(int id, boolean isActive, String createDateTime, String lastChangedDateTime, String firstName, String lastName, String middleName, String phone, String email, String birthdate, String avatarUrl, int companyId) {
        super();
        this.id = id;
        this.isActive = isActive;
        this.createDateTime = createDateTime;
        this.lastChangedDateTime = lastChangedDateTime;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phone = phone;
        this.email = email;
        this.birthdate = birthdate;
        this.avatarUrl = avatarUrl;
        this.companyId = companyId;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("isActive")
    public boolean isIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("createDateTime")
    public String getCreateDateTime() {
        return createDateTime;
    }

    @JsonProperty("createDateTime")
    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    @JsonProperty("lastChangedDateTime")
    public String getLastChangedDateTime() {
        return lastChangedDateTime;
    }

    @JsonProperty("lastChangedDateTime")
    public void setLastChangedDateTime(String lastChangedDateTime) {
        this.lastChangedDateTime = lastChangedDateTime;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("middleName")
    public Object getMiddleName() {
        return middleName;
    }

    @JsonProperty("middleName")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("email")
    public Object getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("birthdate")
    public String getBirthdate() {
        return birthdate;
    }

    @JsonProperty("birthdate")
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @JsonProperty("avatar_url")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @JsonProperty("avatar_url")
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @JsonProperty("companyId")
    public int getCompanyId() {
        return companyId;
    }

    @JsonProperty("companyId")
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof EmployeeResponse that)) return false;
        return getId() == that.getId() && isActive() == that.isActive() && getCompanyId() == that.getCompanyId() && Objects.equals(getCreateDateTime(), that.getCreateDateTime()) && Objects.equals(getLastChangedDateTime(), that.getLastChangedDateTime()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getMiddleName(), that.getMiddleName()) && Objects.equals(getPhone(), that.getPhone()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getBirthdate(), that.getBirthdate()) && Objects.equals(getAvatarUrl(), that.getAvatarUrl()) && Objects.equals(getUrl(), that.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isActive(), getCreateDateTime(), getLastChangedDateTime(), getFirstName(), getLastName(), getMiddleName(), getPhone(), getEmail(), getBirthdate(), getAvatarUrl(), getCompanyId(), getUrl());
    }

    @Override
    public String toString() {
        return "EmployeeResponse{" + "id=" + id + ", isActive=" + isActive + ", createDateTime='" + createDateTime + '\'' + ", lastChangedDateTime='" + lastChangedDateTime + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", middleName=" + middleName + ", phone='" + phone + '\'' + ", email=" + email + ", birthdate=" + birthdate + ", avatarUrl=" + avatarUrl + ", companyId=" + companyId + ", url='" + url + '\'' + '}';
    }
}