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


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public boolean isIsActive() {
        return isActive;
    }


    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }


    public String getCreateDateTime() {
        return createDateTime;
    }


    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }


    public String getLastChangedDateTime() {
        return lastChangedDateTime;
    }


    public void setLastChangedDateTime(String lastChangedDateTime) {
        this.lastChangedDateTime = lastChangedDateTime;
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


    public Object getMiddleName() {
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


    public Object getEmail() {
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
        return getId() == that.getId() && isActive() == that.isActive() && getCompanyId() == that.getCompanyId()
                && Objects.equals(getCreateDateTime(),
                that.getCreateDateTime()) && Objects.equals(getLastChangedDateTime(),
                that.getLastChangedDateTime()) && Objects.equals(getFirstName(),
                that.getFirstName()) && Objects.equals(getLastName(),
                that.getLastName()) && Objects.equals(getMiddleName(),
                that.getMiddleName()) && Objects.equals(getPhone(),
                that.getPhone()) && Objects.equals(getEmail(),
                that.getEmail()) && Objects.equals(getBirthdate(),
                that.getBirthdate()) && Objects.equals(getAvatarUrl(),
                that.getAvatarUrl()) && Objects.equals(getUrl(), that.getUrl()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isActive(), getCreateDateTime(), getLastChangedDateTime(),
                getFirstName(), getLastName(), getMiddleName(), getPhone(), getEmail(), getBirthdate(),
                getAvatarUrl(), getCompanyId(), getUrl()
        );
    }

    @Override
    public String toString() {
        return "\n\nid=" + id +
                ",\nisActive=" + isActive +
                ",\ncreateDateTime='" + createDateTime + '\'' +
                ",\nlastChangedDateTime='" + lastChangedDateTime + '\'' +
                ",\nfirstName='" + firstName + '\'' +
                ",\nlastName='" + lastName + '\'' +
                ",\nmiddleName='" + middleName + '\'' +
                ",\nphone='" + phone + '\'' +
                ",\nemail='" + email + '\'' +
                ",\nbirthdate='" + birthdate + '\'' +
                ",\navatarUrl='" + avatarUrl + '\'' +
                ",\ncompanyId='" + companyId + '\'' +
                ",\nurl='" + url + '\'';
    }
}
