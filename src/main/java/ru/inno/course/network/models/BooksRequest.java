package ru.inno.course.network.models;

import java.util.List;

public class BooksRequest {
    private String userId;

    private List<BookItem> collectionOfIsbns;

    public BooksRequest(String userId, List<BookItem> collectionOfIsbns) {
        this.userId = userId;
        this.collectionOfIsbns = collectionOfIsbns;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<BookItem> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setCollectionOfIsbns(List<BookItem> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }
}
