package ru.inno.course.network.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class CompanyResponse {

    @JsonProperty("id")
    private int id;
    @JsonProperty("isActive")
    private boolean isActive;
    @JsonProperty("createDateTime")
    private String createDateTime;
    @JsonProperty("lastChangedDateTime")
    private String lastChangedDateTime;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("deletedAt")
    private String deletedAt;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "\n\nid=" + id +
                ",\nisActive=" + isActive +
                ",\ncreateDateTime='" + createDateTime + '\'' +
                ",\nlastChangedDateTime='" + lastChangedDateTime + '\'' +
                ",\nname='" + name + '\'' +
                ",\ndescription='" + description + '\'' +
                ",\ndeletedAt='" + deletedAt + '\'';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof CompanyResponse that)) return false;
        return getId() == that.getId() && isActive() == that.isActive() && Objects.equals(getCreateDateTime(), that.getCreateDateTime()) && Objects.equals(getLastChangedDateTime(), that.getLastChangedDateTime()) && Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getDeletedAt(), that.getDeletedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isActive(), getCreateDateTime(), getLastChangedDateTime(), getName(), getDescription(), getDeletedAt());
    }
}
