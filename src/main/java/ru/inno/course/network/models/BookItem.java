package ru.inno.course.network.models;

import java.util.Objects;

public class BookItem {
    private String isbn;

    public BookItem(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof BookItem bookItem)) return false;
        return Objects.equals(getIsbn(), bookItem.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsbn());
    }

    @Override
    public String toString() {
        return isbn;
    }
}
