package ru.inno.course.db.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class EmployeeDb {
    @JsonProperty("id")
    private int id;

    @JsonProperty("is_active")
    private boolean isActive;

    @JsonProperty("create_timestamp")
    private String createTimestamp;

    @JsonProperty("change_timestamp")
    private String changeTimestamp;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("middle_name")
    private String middleName;
    @JsonProperty("phone")
    private String phone;

    @JsonProperty("email")
    private String email;

    @JsonProperty("birthdate")
    private String birthdate;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("company_id")
    private int companyId;

    public EmployeeDb() {
    }

    public EmployeeDb(int id, boolean isActive, String createTimestamp, String changeTimestamp,
                      String firstName, String lastName, String middleName, String phone, String email,
                      String birthdate, String avatarUrl, int companyId) {
        this.id = id;
        this.isActive = isActive;
        this.createTimestamp = createTimestamp;
        this.changeTimestamp = changeTimestamp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phone = phone;
        this.email = email;
        this.birthdate = birthdate;
        this.avatarUrl = avatarUrl;
        this.companyId = companyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getChangeTimestamp() {
        return changeTimestamp;
    }

    public void setChangeTimestamp(String changeTimestamp) {
        this.changeTimestamp = changeTimestamp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", isActive=" + isActive +
                ", createTimestamp='" + createTimestamp + '\'' +
                ", changeTimestamp='" + changeTimestamp + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeDb employee)) return false;
        return getId() == employee.getId() && isActive() == employee.isActive()
                && getCompanyId() == employee.getCompanyId() && Objects.equals(getCreateTimestamp(),
                employee.getCreateTimestamp()) && Objects.equals(getChangeTimestamp(),
                employee.getChangeTimestamp()) && Objects.equals(getFirstName(),
                employee.getFirstName()) && Objects.equals(getLastName(),
                employee.getLastName()) && Objects.equals(getMiddleName(),
                employee.getMiddleName()) && Objects.equals(getPhone(),
                employee.getPhone()) && Objects.equals(getEmail(),
                employee.getEmail()) && Objects.equals(getBirthdate(),
                employee.getBirthdate()) && Objects.equals(getAvatarUrl(), employee.getAvatarUrl()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isActive(), getCreateTimestamp(), getChangeTimestamp(),
                getFirstName(), getLastName(), getMiddleName(), getPhone(),
                getEmail(), getBirthdate(), getAvatarUrl(), getCompanyId()
        );
    }
}
