package ru.inno.course.db.models;

import java.util.Objects;

public class CompanyDb {

    private int id;
    private boolean isActive;
    private String createDateTime;
    private String lastChangedDateTime;
    private String name;
    private String description;
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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof CompanyDb companyDb)) return false;
        return getId() == companyDb.getId() && isActive() == companyDb.isActive() && Objects.equals(getCreateDateTime(), companyDb.getCreateDateTime()) && Objects.equals(getLastChangedDateTime(), companyDb.getLastChangedDateTime()) && Objects.equals(getName(), companyDb.getName()) && Objects.equals(getDescription(), companyDb.getDescription()) && Objects.equals(getDeletedAt(), companyDb.getDeletedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isActive(), getCreateDateTime(), getLastChangedDateTime(), getName(), getDescription(), getDeletedAt());
    }

    @Override
    public String toString() {
        return "id=" + id +
                ",\nisActive=" + isActive +
                ",\ncreateDateTime='" + createDateTime + '\'' +
                ",\nlastChangedDateTime='" + lastChangedDateTime + '\'' +
                ",\nname='" + name + '\'' +
                ",\ndescription='" + description + '\'' +
                ",\ndeletedAt='" + deletedAt + '\'' + "\n\n";
    }
}
